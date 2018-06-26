package com.student.model;

import com.student.node.Biz;
import com.student.node.Id;
import com.student.node.RelationShip;
import com.student.node.RelationType;
import com.student.node.Table;
@Table(name="Tb_persion")
@Biz(name="PersionManagerBiz", className = "com.student.biz.impl.PersionManagerImpl")
public class Tb_persion implements MainModel{
	

	public String name;					//����
	@Id
	//@RelationShip(name="teacherNumber", table ="Tb_position",bizName="PositionManagerBiz",type=RelationType.OneToOne)
	//@RelationShip(name="teacherNumber", table ="Tb_persion",bizName="PersionManagerBiz",type=RelationType.OneToOne)
	//@RelationShip(name="teacherNumber", table = "Tb_education",bizName="EducationManagerBiz",type=RelationType.OneToOne)
	public String teacherNumber;		//�̹����
	public String idCard;   			//���֤
	public String nation;				//����
	public String sex;					//�Ա�
	public String birth;				//����
	public String joinPartyTime;			//�뵳ʱ��
	public String nativePlace;				//����
	public String placeBirth;				//������
	public String politicalStatus;			//������ò
	public String workingHours;				//�μӹ���ʱ��
	public String admissionTime;			//��Уʱ��
	
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
