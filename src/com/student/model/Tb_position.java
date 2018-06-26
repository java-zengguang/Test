package com.student.model;

import com.student.node.Biz;
import com.student.node.Id;
import com.student.node.RelationShip;
import com.student.node.RelationType;
import com.student.node.Table;

@Table(name="Tb_position")
@Biz(name="PositionManagerBiz", className = "com.student.biz.impl.PersionManagerImpl")
public class Tb_position implements MainModel{
	public String department;      			//����
	public String threeLevelInstitution;	//��������
	public String postNature; 				//��λ���� 
	public String postGrade;				//��λ�ȼ�
	public String appointmentCurrentTime;	//Ƹ�ָ�ʱ�� 
	public String appointmentTime;			//Ƹ��ʱ��
	public String aboveMiddleLevel;			//�Ƿ��в�����
	public String aboveSubtropicalHigh;		//�Ƿ񸱸�����
	public String frontlineTeachers;		//�Ƿ�һ�߽�ʦ 
	public String status;					//���
	public String post;						//��λ
	public String fullTimeTeacher;			//�Ƿ�ת�ν�ʦ
	public String divisionSystem;			//����ϵ�� 
	public String divisionTeachingOffices;	//���ֽ�����
	public String wageExecutionSeries;		//����ִ��ϵ�� 
	public String allowanceRate;				//������׼
	public String administrativeLevelTime;		//��������ʱ�� 
	@Id
	@RelationShip(name="teacherNumber", table = "Tb_persion",bizName="PersionManagerBiz",type=RelationType.OneToOne)
	public String teacherNumber;			//�̹����
	public Tb_position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tb_position(String department, String threeLevelInstitution,
			String postNature, String postGrade, String appointmentCurrentTime,
			String appointmentTime, String aboveMiddleLevel,
			String aboveSubtropicalHigh, String frontlineTeachers,
			String status, String post, String fullTimeTeacher,
			String divisionSystem, String divisionTeachingOffices,
			String wageExecutionSeries, String allowanceRate,
			String administrativeLevelTime, String teacherNumber) {
		super();
		this.department = department;
		this.threeLevelInstitution = threeLevelInstitution;
		this.postNature = postNature;
		this.postGrade = postGrade;
		this.appointmentCurrentTime = appointmentCurrentTime;
		this.appointmentTime = appointmentTime;
		this.aboveMiddleLevel = aboveMiddleLevel;
		this.aboveSubtropicalHigh = aboveSubtropicalHigh;
		this.frontlineTeachers = frontlineTeachers;
		this.status = status;
		this.post = post;
		this.fullTimeTeacher = fullTimeTeacher;
		this.divisionSystem = divisionSystem;
		this.divisionTeachingOffices = divisionTeachingOffices;
		this.wageExecutionSeries = wageExecutionSeries;
		this.allowanceRate = allowanceRate;
		this.administrativeLevelTime = administrativeLevelTime;
		this.teacherNumber = teacherNumber;
	}
	@Override
	public String toString() {
		return "Tb_position [department=" + department
				+ ", threeLevelInstitution=" + threeLevelInstitution
				+ ", postNature=" + postNature + ", postGrade=" + postGrade
				+ ", appointmentCurrentTime=" + appointmentCurrentTime
				+ ", appointmentTime=" + appointmentTime
				+ ", aboveMiddleLevel=" + aboveMiddleLevel
				+ ", aboveSubtropicalHigh=" + aboveSubtropicalHigh
				+ ", frontlineTeachers=" + frontlineTeachers + ", status="
				+ status + ", post=" + post + ", fullTimeTeacher="
				+ fullTimeTeacher + ", divisionSystem=" + divisionSystem
				+ ", divisionTeachingOffices=" + divisionTeachingOffices
				+ ", wageExecutionSeries=" + wageExecutionSeries
				+ ", allowanceRate=" + allowanceRate
				+ ", administrativeLevelTime=" + administrativeLevelTime
				+ ", teacherNumber=" + teacherNumber + "]";
	}
	
	
	
}
