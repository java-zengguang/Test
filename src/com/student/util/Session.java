package com.student.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jdbc.tools.FieldSet;
import com.jdbc.tools.FileUtil;
import com.student.biz.inter.ModelManagerInte;
import com.student.model.Model;
import com.student.node.Biz;
import com.student.node.Id;
import com.student.node.RelationShip;
import com.student.node.RelationType;
import com.student.node.Table;

public class Session {
	private	Map<String,ModelManagerInte> bizMap=new HashMap<String,ModelManagerInte>();
	private Map relationshipMap=new HashMap();
	private Map primaryKey=new HashMap(); 
	
	{
		
		/*bizMap.put("Tb_persion", (ModelManagerInte)BeanFactory.createBean("PersionManagerBiz"));
		bizMap.put("Tb_education", (ModelManagerInte)BeanFactory.createBean("EducationManagerBiz"));
		bizMap.put("Tb_position",(ModelManagerInte) BeanFactory.createBean("PositionManagerBiz"));
		bizMap.put("Tb_technology",(ModelManagerInte) BeanFactory.createBean("TechnologyManagerBiz"));
		bizMap.put("Users",(ModelManagerInte) BeanFactory.createBean("UsersManagerBiz"));*/
		//bizMap.put("x",(ModelManagerInte) BeanFactory.createBean("XManagerBiz"));
	
	
	
		
	Package p=Model.class.getPackage();	
	
	
	
	
	
	
	
	//String className= p.getName()+"."+"Tb_education";

	List<Class> list=new ArrayList<Class>();
	try {
		list = FileUtil.getClassFormPackage(p.getName(), true, Table.class);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
for(Class classx:list){
	
	if(classx.isAnnotationPresent(Table.class)){
		Table table=(Table)classx.getAnnotation(Table.class);
		String tableName=table.name();
		Biz biz=(Biz) classx.getAnnotation(Biz.class);
		String bizName=biz.name();
		bizMap.put(tableName, (ModelManagerInte)BeanFactory.createBean(bizName));
	}
	
	for(Field field:classx.getFields()){
		if(field.isAnnotationPresent(Id.class)){
		field.getAnnotation(Id.class);
		primaryKey.put(classx.getSimpleName(),field.getName());
		}
		
		if(field.isAnnotationPresent(RelationShip.class)){
			RelationShip OTO=field.getAnnotation(RelationShip.class);
			String table=OTO.table();
			String name=OTO.name();
			String bizName=OTO.bizName();
			RelationType type=OTO.type();
			Map relation=new HashMap();
			relation.put("me", classx.getSimpleName());
			relation.put("table",table);
			relation.put("name", name);
			relation.put("type", type);
			relationshipMap.put(classx.getSimpleName()+"."+field.getName()+"="+table+"."+name, relation);
		}
		
	}
	
}
	
	}
	

	
	public void judgeFKD(String table,Model model){
		
		Set<String> rsm=relationshipMap.keySet();
		for(String rs:rsm){
			
			Map relationShip=(Map) relationshipMap.get(rs);
			if(relationShip.get("me").equals(table)){

			
			if(relationShip.get("type").equals(RelationType.OneToMany)){
				
			}
		
		
		}
			
			if(relationShip.get("table").equals(table)){
				
				if(relationShip.get("type").equals(RelationType.OneToOne)){
					System.out.println(relationShip.get("type"));	
					String terms;
					try {
						terms = relationShip.get("name")+"="+model.getClass().getField(relationShip.get("name")+"").get(model);
						if(find(relationShip.get("me")+"",terms).size()>0){  
						
								 delete(relationShip.get("me")+"",terms);
								 System.out.println("删除____________________________"+table);
								 System.out.println("term+++++++++++++++++++++++:"+terms);
				
							}
						 
						} catch (IllegalArgumentException | IllegalAccessException
							| NoSuchFieldException | SecurityException e) {
							e.printStackTrace();
						}
					
					}
					
					if(relationShip.get("type").equals(RelationType.OneToMany)){
						
					}
					
				
				}
				
				
			}
			
		}
	
	
	
public void judgeFKU(String table,Model smodel,Model nmodel){
		
		Set<String> rsm=relationshipMap.keySet();
		for(String rs:rsm){
			
			Map relationShip=(Map) relationshipMap.get(rs);
			if(relationShip.get("me").equals(table)){
				
					
					if(relationShip.get("type").equals(RelationType.OneToOne)){
						
					}
						
				
			
			if(relationShip.get("type").equals(RelationType.OneToMany)){
				
			}
		
		
		}
			
			if(relationShip.get("table").equals(table)){
				
				if(relationShip.get("type").equals(RelationType.OneToOne)){
					String terms;
					try {
						terms = relationShip.get("name")+"="+smodel.getClass().getField(relationShip.get("name")+"").get(smodel);
						if(find(relationShip.get("me")+"",terms).size()>0){  
							List<Model> list=find(relationShip.get("me")+"",terms);
							Field f1=smodel.getClass().getField(relationShip.get("name")+"");
							String value=(String) f1.get(nmodel);
							for(Model m:list){
								Field f=m.getClass().getField(relationShip.get("name")+"");
								f.set(m,value);
								 update(relationShip.get("me")+"",m,terms);
								 System.out.println("修改____________________________"+table);
								 System.out.println("term+++++++++++++++++++++++:"+terms);
							}
							}
						 
						} catch (IllegalArgumentException | IllegalAccessException
							| NoSuchFieldException | SecurityException e) {
							e.printStackTrace();
						}
					
					}
					
					if(relationShip.get("type").equals(RelationType.OneToMany)){
						
					}
					
				
				}
				
				
			}
			
		}
	


public int judgeFKA(String table,Model model){
	
	Set<String> rsm=relationshipMap.keySet();
	for(String rs:rsm){
		
		Map relationShip=(Map) relationshipMap.get(rs);
		if(relationShip.get("me").equals(table)){
			
				
				if(relationShip.get("type").equals(RelationType.OneToOne)){
					String terms;
					try {
						terms = relationShip.get("name")+"="+model.getClass().getField(relationShip.get("name")+"").get(model);
						return find(relationShip.get("table")+"",terms).size();
						
						 
						} catch (IllegalArgumentException | IllegalAccessException
							| NoSuchFieldException | SecurityException e) {
							return -2;
						}
					
					
				}
					
			
		
		if(relationShip.get("type").equals(RelationType.OneToMany)){
			
		}
	
	
	}
		
		if(relationShip.get("table").equals(table)){
			
			if(relationShip.get("type").equals(RelationType.OneToOne)){
				String terms;
				try {
					terms = relationShip.get("name")+"="+model.getClass().getField(relationShip.get("name")+"").get(model);
					return find(relationShip.get("me")+"",terms).size();
					
					 
					} catch (IllegalArgumentException | IllegalAccessException
						| NoSuchFieldException | SecurityException e) {
						return -2;
					}
				
				}
				
				if(relationShip.get("type").equals(RelationType.OneToMany)){
					
				}
				
			
			}
			
			
		}
	
	return 0;
		
	}



	
public  boolean delete(String table,String... terms){
	
	ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
	List<Model> list=mmi.find(terms);
	for(Model model:list){
		judgeFKD(table,model);
	}
	return 	mmi.delete(terms);
}
	
public	boolean update(String table,Model model,String... terms){
	if(judgePK(table,model)>1){
		System.out.println("修改失败，主键约束");
		return false;
	}
		ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
		List<Model> list=mmi.find(terms);
		for(Model smodel:list){
		judgeFKU(table, smodel,model);
		}
		return mmi.update(model, terms);
	}
	
public	boolean update(String table,Model model,int index){


	if(judgePK(table,model)>1){
		System.out.println("添加失败，主键约束");
		return false;
	}
	ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
	List<Model> list=mmi.getData();
	Model smodel=list.get(index);
	judgeFKU(table, smodel,model);
	
		return mmi.update(model, index);
	}
	
public	List find(String table,String... terms){
		ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
		return mmi.find(terms);
	}
	
public	boolean sort(String table,String... terms){
		ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
		return mmi.sort(terms);
	}
	
public	boolean memory(boolean isCover){
		return true;
	}
	
public	boolean read(){
		return true;
	}
	
public	boolean submit(){
		return true;
	}
	



public	boolean load(){
		for(String bizName:bizMap.keySet()){
			ModelManagerInte mmi=bizMap.get(bizName);
			if(!mmi.load()){
				return false;
			}
			System.out.println(bizName+"成功加载");
		}
		return true;
	}
	
public	boolean upLoad(){
	for(String bizName:bizMap.keySet()){
		ModelManagerInte mmi=bizMap.get(bizName);
		if(!mmi.upLoad()){
			return false;
		}
	}
	return true;
	}
	
public	boolean upLoad(String table){
		ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
		
		return mmi.upLoad();
	}
	
public	List getData(String table){
		ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
		return mmi.getData();
	}
	
public	boolean enSure(){
		return true;
	}
	
public	boolean backSpace(){
		return true;
	}

public int judgePK(String table,Model model){
	String pk=(String) primaryKey.get(table);
	if(pk!=null){
		try {
			ModelManagerInte mmi= (ModelManagerInte) getBiz(table);

			String terms=pk+"="+model.getClass().getField(pk).get(model);
			List list=mmi.find(terms);
			int x=list.size();
			
				return x; 
				
		} catch (Exception e) {
			
			e.printStackTrace();
			return -2;	
		}
}
	return -1;
}



public	boolean add(String table,Model model) {

	
		if(judgePK(table,model)>0){
			System.out.println("添加失败，主键约束");
			return false;
		}
		if(judgeFKA(table,model)<=0){
			System.out.println("添加失败，外键约束");
			return false;
		}
		
		
		ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
		
		return  mmi.add(model);
	
	}
	
public	boolean add(String table,List<Model> model_list){
		
		for(Model model:model_list){
			if(judgePK(table,model)>0){
				System.out.println("添加失败，主键约束");
				return false;
			}
		}
		ModelManagerInte mmi= (ModelManagerInte) getBiz(table);
		return  mmi.add(model_list);
	}
	
public	boolean x()throws Exception{
		return true;
	}
	
public	boolean delete(String table,int index){
	
		ModelManagerInte mmi= (ModelManagerInte)getBiz(table);
		Model model=(Model) mmi.getData().get(index);
		judgeFKD(table,model);
		return mmi.delete(index);
	}

	
public void showRelationShip(){
	System.out.println(relationshipMap);
}	
	

public Object getBiz(String tableName){
	if(bizMap.keySet().contains(tableName)){
		return bizMap.get(tableName);
	}else{
		System.out.println("没有这个biz");
		return null;
	}
	
	
}
}
