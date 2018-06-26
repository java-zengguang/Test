package com.student.model;

import com.student.node.Biz;
import com.student.node.Id;
import com.student.node.RelationShip;
import com.student.node.RelationType;
import com.student.node.Table;

@Table(name="Tb_technology")
@Biz(name="TechnologyManagerBiz", className = "com.student.biz.impl.TechnologyManagerImpl")
public class Tb_technology implements MainModel{
	public String TPQL; //技术职务资格级别
	public String eligibilityTime;				//取得资格时间
	public String employmentTechnicalPosts;  //聘任技术职务
	public String technicalJobLevel;		   //技术职务级别
	public String belongAProfession; 		  //归属专业
	public String belongProfessionTruth;  //归属专业（真实）
	public String belongProfessionalSchool;  	//归属专业全校范围
	public String secondaryDiscipline;			//二级学科 
	public String professionalLeader;			//专业带头人
	public String CSCSB;		//地震局综合统计分类 
	public String CCDI;			//事业单位机构编制数据采集分类
	public String professionalClassification;	//专业分类 
	public String TQC; //教师资格证书
	@Id
	@RelationShip(name="teacherNumber", table = "Tb_persion",bizName="PersionManagerBiz",type=RelationType.OneToOne)
	public String teacherNumber;			//教工编号
	
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
