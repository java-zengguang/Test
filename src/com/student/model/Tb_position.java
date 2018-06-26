package com.student.model;

import com.student.node.Biz;
import com.student.node.Id;
import com.student.node.RelationShip;
import com.student.node.RelationType;
import com.student.node.Table;

@Table(name="Tb_position")
@Biz(name="PositionManagerBiz", className = "com.student.biz.impl.PersionManagerImpl")
public class Tb_position implements MainModel{
	public String department;      			//部门
	public String threeLevelInstitution;	//三级机构
	public String postNature; 				//岗位性质 
	public String postGrade;				//岗位等级
	public String appointmentCurrentTime;	//聘现岗时间 
	public String appointmentTime;			//聘任时间
	public String aboveMiddleLevel;			//是否中层以上
	public String aboveSubtropicalHigh;		//是否副高以上
	public String frontlineTeachers;		//是否一线教师 
	public String status;					//身份
	public String post;						//岗位
	public String fullTimeTeacher;			//是否转任教师
	public String divisionSystem;			//划分系部 
	public String divisionTeachingOffices;	//划分教研室
	public String wageExecutionSeries;		//工资执行系列 
	public String allowanceRate;				//津贴标准
	public String administrativeLevelTime;		//行政级别时间 
	@Id
	@RelationShip(name="teacherNumber", table = "Tb_persion",bizName="PersionManagerBiz",type=RelationType.OneToOne)
	public String teacherNumber;			//教工编号
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
