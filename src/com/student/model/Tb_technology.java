package com.student.model;

import com.student.node.Biz;
import com.student.node.Id;
import com.student.node.RelationShip;
import com.student.node.RelationType;
import com.student.node.Table;

@Table(name="Tb_technology")
@Biz(name="TechnologyManagerBiz", className = "com.student.biz.impl.TechnologyManagerImpl")
public class Tb_technology implements MainModel{
	public String TPQL; //����ְ���ʸ񼶱�
	public String eligibilityTime;				//ȡ���ʸ�ʱ��
	public String employmentTechnicalPosts;  //Ƹ�μ���ְ��
	public String technicalJobLevel;		   //����ְ�񼶱�
	public String belongAProfession; 		  //����רҵ
	public String belongProfessionTruth;  //����רҵ����ʵ��
	public String belongProfessionalSchool;  	//����רҵȫУ��Χ
	public String secondaryDiscipline;			//����ѧ�� 
	public String professionalLeader;			//רҵ��ͷ��
	public String CSCSB;		//������ۺ�ͳ�Ʒ��� 
	public String CCDI;			//��ҵ��λ�����������ݲɼ�����
	public String professionalClassification;	//רҵ���� 
	public String TQC; //��ʦ�ʸ�֤��
	@Id
	@RelationShip(name="teacherNumber", table = "Tb_persion",bizName="PersionManagerBiz",type=RelationType.OneToOne)
	public String teacherNumber;			//�̹����
	
	public Tb_technology(){}

	public Tb_technology(String tPQL, String eligibilityTime,
			String employmentTechnicalPosts, String technicalJobLevel,
			String belongAProfession, String belongProfessionTruth,
			String belongProfessionalSchool, String secondaryDiscipline,
			String professionalLeader, String cSCSB, String cCDI,
			String professionalClassification, String tQC, String teacherNumber) {
		super();
		TPQL = tPQL;
		this.eligibilityTime = eligibilityTime;
		this.employmentTechnicalPosts = employmentTechnicalPosts;
		this.technicalJobLevel = technicalJobLevel;
		this.belongAProfession = belongAProfession;
		this.belongProfessionTruth = belongProfessionTruth;
		this.belongProfessionalSchool = belongProfessionalSchool;
		this.secondaryDiscipline = secondaryDiscipline;
		this.professionalLeader = professionalLeader;
		CSCSB = cSCSB;
		CCDI = cCDI;
		this.professionalClassification = professionalClassification;
		TQC = tQC;
		this.teacherNumber = teacherNumber;
	}


	
}
