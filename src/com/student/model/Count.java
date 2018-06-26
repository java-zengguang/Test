package com.student.model;

public class Count implements ContainModel{
	public String tn;//教职工总数
	public String dn;//博士人数
	public String mn;//硕士人数
	public String ftn;//一线教师人数
	public String fg; //副高以上
	public String psn; //党员人数
	public Count(String tn, String dn, String mn, String ftn, String fg,
			String psn) {
		super();
		this.tn = tn;
		this.dn = dn;
		this.mn = mn;
		this.ftn = ftn;
		this.fg = fg;
		this.psn = psn;
	}
	@Override
	public String toString() {
		return "Count [tn=" + tn + ", dn=" + dn + ", mn=" + mn + ", ftn=" + ftn
				+ ", fg=" + fg + ", psn=" + psn + "]";
	}
	
	
}
