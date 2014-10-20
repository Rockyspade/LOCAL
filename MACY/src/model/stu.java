package model;

public class stu {
	private String Snum;
	private String  Score;
	private String  Sname;
	private String  Cname;
	public String getSnum() {
		return Snum;
	}
	public void setSnum(String snum) {
		Snum = snum;
	}
	public String getScore() {
		return Score;
	}
	public void setScore(String score) {
		Score = score;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	@Override
	public String toString() {
		return "stu [Snum=" + Snum + ", Score=" + Score + ", Sname=" + Sname
				+ ", Cname=" + Cname + "]";
	}
	public stu(String snum, String score, String sname, String cname) {
		super();
		Snum = snum;
		Score = score;
		Sname = sname;
		Cname = cname;
	}
	
}
