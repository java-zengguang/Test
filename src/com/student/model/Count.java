package com.student.model;

public class Count implements ContainModel{
	public String tn;//��ְ������
	public String dn;//��ʿ����
	public String mn;//˶ʿ����
	public String ftn;//һ�߽�ʦ����
	public String fg; //��������
	public String psn; //��Ա����
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
