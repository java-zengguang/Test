package com.jdbc.tools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import com.student.model.MainModel;
import com.student.model.Tb_persion;



public class FileCtrl {
	
	
	public static String getProjectPath(){
		String path="";
		try {
			path=FileCtrl.class.getResource("/").toURI().getPath();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
	
	//��tableд���ļ��У�����table��list<Model>������
	public static void tableToFile(File file,List<MainModel> list,String charset,boolean append) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException{
		
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,append),charset));

		List<String> slist=new ArrayList<String>();   //list<String>���ڴ��List<Model>�е�ÿ������ת��ΪString����
		String line=new String();
		MainModel model=(MainModel)list.get(0);//���һ��model
		Field fs[]=model.getClass().getFields();
		//����table�ı�ͷ
		for(Field f:fs){
			String s=f.getName()+"         ";    //ÿ�������м������ո�
			line=line+s+"   ";
		}
		if(!append){
		slist.add(line.toString());     //����ͷ���ڵ�һ��
		}
		//��model������ת��ΪString����list��
		Iterator it=list.iterator();
		while(it.hasNext()){
			line=new String();
			model=(MainModel) it.next();
			fs=model.getClass().getFields();
			for(Field f:fs){
				f.isAccessible();
				String name=f.getName();
				  name = name.substring(0, 1).toUpperCase() + name.substring(1);//�����get����������
				  Method m=model.getClass().getMethod("get"+name);//ʹ��get����ʵ�������޸�
				  
				line=line+m.invoke(model)+"           ";
			}
		slist.add(line);
		}
		
		//��listд���ļ���
		it=slist.iterator();
		while(it.hasNext()){
		out.write((String)it.next());
		out.newLine();
		}
		out.close();
	}

	public static List<MainModel> tableFromFile(File file,MainModel model,String charset) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));
		String line=null;
		
		List<Map> list=new ArrayList<Map>();
		List<MainModel> list_model=new ArrayList<MainModel>();
		String fristLine=in.readLine();
		if(fristLine==null){
			fristLine="";
			Field fields[]=model.getClass().getFields();
			for(Field f:fields){
				fristLine=fristLine+f.getName()+" ";
			}
		
		}
		String  mem_name[]=fristLine.split("\\s{1,}|/t");  //������ʽ��ʾ����ո�
		while((line=in.readLine()) != null){
			Map map=new HashMap();    //ÿ�е�map�������µĶ��󣬷���ѹ��list��map��Զ����һ������map��ֵ�����һ���޸ĵ�ֵ
			String mem[]=line.split("\\s{1,}|/t");
		
			for(int i=0;i<mem.length;i++){
		
				map.put(mem_name[i], mem[i]);
				
			}
			list.add(map);
		}

		
		list_model=setMember(list,model);

		return list_model;
	}

	
	public static Object setMember(Map map,Object o) throws InstantiationException, IllegalAccessException, IllegalArgumentException, IOException, ClassNotFoundException {
	//	System.out.println("�������е�o"+o.getClass().getName());
		Field fields[]=o.getClass().getFields();
		for(Field f:fields){
			if(!f.getType().isPrimitive() && !f.getType().getSimpleName().equals("String")){
				Object no=setMember(map,f.get(o).getClass().newInstance());
				f.set(o, no);
			}else{
			f.setAccessible(true);
			if(map.get(f.getName().toUpperCase())!=null)
			FieldSet.setField(f, o, (String) map.get(f.getName().toUpperCase()));
			}
		}
		//���л�����ʵ����ȿ�¡
		  ByteArrayOutputStream	 bos=new ByteArrayOutputStream();
		ObjectOutputStream out=new ObjectOutputStream(bos);
		out.writeObject(o);
		ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
		Object o_copy= in.readObject();   //�˴�����ֱ���þɶ�������ã���Ϊmodel��Ӱ����һ��ѭ��
		
		//���������list��
		return o_copy;
	}

	//ʹ�÷����ȡmodel�����Խṹ���������ģ�Ͳ�����
		public static List setMember(List list,Object model) throws Exception{
			Field[] model_fields=model.getClass().getFields();
			Map map=new HashMap();
			List model_list=new ArrayList();
			for(int i=0;i<list.size();i++){
				model_list.add(FieldSet.translateNull(setMember((Map)list.get(i),model.getClass().newInstance())));
				
			}
			
			return model_list;
		}

		
		
		
	private int explainOrder(){
		return 0;
	}

	public static boolean writeXML(List model_list,File file,String charSet) {
		StringBuffer line=new StringBuffer();
		List<String> line_list=new ArrayList();
		try {
		line.append("<?xml version=\"1.0\" encoding=\"");
		line.append(charSet);
		line.append("\"?>");
		line_list.add(line.toString());
		line.delete(0, line.length());
		line.append("<root>");
		line_list.add(line.toString());
		line.delete(0, line.length());
		Iterator it=model_list.iterator();
		while(it.hasNext()){
			Object model=it.next();
			String className=model.getClass().getSimpleName();
			line.append("<"+className+" class=\""+model.getClass().getName()+"\">");
			line_list.add(line.toString());
			line.delete(0, line.length());
			Field fields[]=model.getClass().getFields();
			for(Field f:fields){
				String fieldName=f.getName();
			line.append("<"+fieldName+" type=\""+f.getType().getSimpleName()+"\">"+f.get(model)+"</"+fieldName+">");
			line_list.add(line.toString());
			line.delete(0, line.length());
			
			}
			line.append("</"+className+">");
			line_list.add(line.toString());
			line.delete(0, line.length());
		}
			line.append("</root>");
			line_list.add(line.toString());
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),charSet));
			for(String wLine:line_list){
			out.write(wLine);
			out.newLine();
			}
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public static List readXML(File file) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		SAXReader reader=new SAXReader();
		Document document=reader.read(file);
		Element rootNode=document.getRootElement();
		List model_list=new ArrayList();
		model_list=nodeToList(model_list,rootNode);
		return model_list;
	}
	private static List nodeToList(List model_list,Node node) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		List<Attribute> attributes=new ArrayList<Attribute>();
		List<Element> elements=new ArrayList<Element>();
		if(node instanceof Element){
			
			Element element=(Element)node;
			attributes=element.attributes();
			elements=element.elements();	
			for(Attribute a:attributes){
				model_list=nodeToList(model_list,a);
			}
			for(Element e:elements){
				model_list=nodeToList(model_list,e);
			}
		}
		if(node instanceof Attribute){
			Attribute attribute=(Attribute) node;
			if(attribute.getName().equals("class")){
				
				Object model=Class.forName(attribute.getValue()).newInstance();
				// System.out.println("��new��model"+model);
				 model_list.add(model);
			}
			if(attribute.getName().equals("type")){
				Object model=model_list.get(model_list.size()-1);
				
				Field field=model.getClass().getField(attribute.getParent().getName());
				FieldSet.setField(field, model, attribute.getParent().getStringValue());
			}
			
		}
		return model_list;
	}
	
	
	

	
	
	}


