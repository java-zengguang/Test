package com.student.model;

import com.student.node.Biz;
import com.student.node.Id;
import com.student.node.RelationShip;
import com.student.node.RelationType;
import com.student.node.Table;
@Table(name="Tb_persion")
@Biz(name="PersionManagerBiz", className = "com.student.biz.impl.PersionManagerImpl")
public class Tb_persion implements MainModel{
	

	public String name;					//姓名
	@Id
	//@RelationShip(name="teacherNumber", table ="Tb_position",bizName="PositionManagerBiz",type=RelationType.OneToOne)
	//@RelationShip(name="teacherNumber", table ="Tb_persion",bizName="PersionManagerBiz",type=RelationType.OneToOne)
	//@RelationShip(name="teacherNumber", table = "Tb_education",bizName="EducationManagerBiz",type=RelationType.OneToOne)
	public String teacherNumber;		//教工编号
	public String idCard;   			//身份证
	public String nation;				//民族
	public String sex;					//性别
	public String birth;				//出生
	public String joinPartyTime;			//入党时间
	public String nativePlace;				//籍贯
	public String placeBirth;				//出生地
	public String politicalStatus;			//政治面貌
	public String workingHours;				//参加工作时间
	public String admissionTime;			//入校时间
	
	public Tb_persion(){}
	
	public Tb_persion(String name, String teacherNumber, String idCard,
			String nation, String sex, String birth, String joinPartyTime,
			String nativePlace, String placeBirth, String politicalStatus,
			String workingHours, String admissionTime) {
		super();
		this.name = name;
		this.teacherNumber = teacherNumber;
		this.idCard = idCard;
		this.nation = nation;
		this.sex = sex;
		this.birth = birth;
		this.joinPartyTime = joinPartyTime;
		this.nativePlace = nativePlace;
		this.placeBirth = placeBirth;
		this.politicalStatus = politicalStatus;
		this.workingHours = workingHours;
		this.admissionTime = admissionTime;
	}

	@Override
	public String toString() {
		return "Tb_persion [name=" + name + ", teacherNumber=" + teacherNumber
				+ ", idCard=" + idCard + ", nation=" + nation + ", sex=" + sex
				+ ", birth=" + birth + ", joinPartyTime=" + joinPartyTime
				+ ", nativePlace=" + nativePlace + ", placeBirth=" + placeBirth
				+ ", politicalStatus=" + politicalStatus + ", workingHours="
				+ workingHours + ", admissionTime=" + admissionTime + "]";
	}
	
	
	
}
