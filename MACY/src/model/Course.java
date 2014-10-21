package model;

public class Course {
	private String  Cnum;   //课程号
	private String  Cname;  //课程名
	private int  Ccredit;  //学分
	
	public String getCnum() {
		return Cnum;
	}
	public void setCnum(String cnum) {
		Cnum = cnum;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public int getCcredit() {
		return Ccredit;
	}
	public void setCcredit(int ccredit) {
		Ccredit = ccredit;
	}
	
	public Course(String cnum, String cname, int ccredit) {
		super();
		Cnum = cnum;
		Cname = cname;
		Ccredit = ccredit;
	}
	public Course(String cnum, String cname) {
		super();
		Cnum = cnum;
		Cname = cname;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [Cnum=" + Cnum + ", Cname=" + Cname + ", Ccredit="
				+ Ccredit + "]";
	}
	
}
