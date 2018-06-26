package com.student.model;

import com.student.node.*;
@Table(name="Tb_education")
@Biz(name="EducationManagerBiz", className = "com.student.biz.impl.EducationManagerImpl")
public class Tb_education implements MainModel{
	public String firstEducation;   //第一学历
	public String firstDegree;		//第一学位
	public String firstDegreeUniversity;					//第一学历毕业院校
	public String firstMajor;				//第一学历专业
	public String firstDegreeTime;				//第一学历毕业时间
	public String supremeDegree;					//最高学位
	public String supremeDegreeUnit;				//最高学位单位
	public String supremeMajor;					//最高学位专业
	public String supremeMajorTime;					//最高学历获得时间
	@Id
	@RelationShip(name="teacherNumber", table ="Tb_persion",bizName="PersionManagerBiz",type=RelationType.OneToOne)
	public String teacherNumber;//教工编号
	
	public Tb_education(){}
	public Tb_education(String firstEducation, String firstDegree,
			String firstDegreeUniversity, String firstMajor,
			String firstDegreeTime, String supremeDegree,
			String supremeDegreeUnit, String supremeMajor,
			String supremeMajorTime, String teacherNumber) {
		super();
		this.firstEducation = firstEducation;
		this.firstDegree = firstDegree;
		this.firstDegreeUniversity = firstDegreeUniversity;
		this.firstMajor = firstMajor;
		this.firstDegreeTime = firstDegreeTime;
		this.supremeDegree = supremeDegree;
		this.supremeDegreeUnit = supremeDegreeUnit;
		this.supremeMajor = supremeMajor;
		this.supremeMajorTime = supremeMajorTime;
		this.teacherNumber = teacherNumber;
	}
	@Override
	public String toString() {
		return "Tb_education [firstEducation=" + firstEducation
				+ ", firstDegree=" + firstDegree + ", firstDegreeUniversity="
				+ firstDegreeUniversity + ", firstMajor=" + firstMajor
				+ ", firstDegreeTime=" + firstDegreeTime + ", supremeDegree="
				+ supremeDegree + ", supremeDegreeUnit=" + supremeDegreeUnit
				+ ", supremeMajor=" + supremeMajor + ", supremeMajorTime="
				+ supremeMajorTime + ", teacherNumber=" + teacherNumber + "]";
	}
	
	
	
}
