package com.student.model;

import com.student.node.*;
@Table(name="Tb_education")
@Biz(name="EducationManagerBiz", className = "com.student.biz.impl.EducationManagerImpl")
public class Tb_education implements MainModel{
	public String firstEducation;   //��һѧ��
	public String firstDegree;		//��һѧλ
	public String firstDegreeUniversity;					//��һѧ����ҵԺУ
	public String firstMajor;				//��һѧ��רҵ
	public String firstDegreeTime;				//��һѧ����ҵʱ��
	public String supremeDegree;					//���ѧλ
	public String supremeDegreeUnit;				//���ѧλ��λ
	public String supremeMajor;					//���ѧλרҵ
	public String supremeMajorTime;					//���ѧ�����ʱ��
	@Id
	@RelationShip(name="teacherNumber", table ="Tb_persion",bizName="PersionManagerBiz",type=RelationType.OneToOne)
	public String teacherNumber;//�̹����
	
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
