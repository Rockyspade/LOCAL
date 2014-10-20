package model;

public class table {
	private String cnum;
	private String sclass;
	private String sname;
	private String score;
	private String cname;
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "table [cnum=" + cnum + ", sclass=" + sclass + ", sname="
				+ sname + ", score=" + score + ", cname=" + cname + "]";
	}
	public table(String cnum, String sclass, String sname, String score,
			String cname) {
		super();
		this.cnum = cnum;
		this.sclass = sclass;
		this.sname = sname;
		this.score = score;
		this.cname = cname;
	}
	
}
