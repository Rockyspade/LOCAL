package model;

public class Student {
	private  String  Snum;    //学号
	private  String  Sclass;    //班级
	private  String  Sname;   //姓名
	private  String  Ssex;      //性别
	private  int Sage;           //年龄
	private  String  Sphone;  //电话
	public String getSnum() {
		return Snum;
	}
	public void setSnum(String snum) {
		Snum = snum;
	}
	public String getSclass() {
		return Sclass;
	}
	public void setSclass(String sclass) {
		Sclass = sclass;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public int getSage() {
		return Sage;
	}
	public void setSage(int sage) {
		Sage = sage;
	}
	public String getSphone() {
		return Sphone;
	}
	public void setSphone(String sphone) {
		Sphone = sphone;
	}
	public Student(String snum, String sclass, String sname, String ssex,
			int sage, String sphone) {
		super();
		Snum = snum;
		Sclass = sclass;
		Sname = sname;
		Ssex = ssex;
		Sage = sage;
		Sphone = sphone;
	}
	
	public Student(String snum, String sclass, String sname, String ssex,
			String sphone) {
		super();
		Snum = snum;
		Sclass = sclass;
		Sname = sname;
		Ssex = ssex;
		Sphone = sphone;
	}
	public Student(String snum, String sclass, String sname, String ssex,
			int sage) {
		super();
		Snum = snum;
		Sclass = sclass;
		Sname = sname;
		Ssex = ssex;
		Sage = sage;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [Snum=" + Snum + ", Sclass=" + Sclass + ", Sname="
				+ Sname + ", Ssex=" + Ssex + ", Sage=" + Sage + ", Sphone="
				+ Sphone + "]";
	}
	
	
}

