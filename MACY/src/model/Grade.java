package model;

public class Grade {
	    private Integer id;
		private String Snum; //	Snum	�ַ���	10	ѧ��
		private String Cnum; //		Cnum	�ַ���	4	�γ̺�
		private String  Score; //		Score	�ַ���	3	�ɼ�
	public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getSnum() {
			return Snum;
		}
		public void setSnum(String snum) {
			Snum = snum;
		}
		public String getCnum() {
			return Cnum;
		}
		public void setCnum(String cnum) {
			Cnum = cnum;
		}
		public String getScore() {
			return Score;
		}
		public void setScore(String score) {
			Score = score;
		}
		@Override
		public String toString() {
			return "Scores [Snum=" + Snum + ", Cnum=" + Cnum + ", Score=" + Score
					+ "]";
		}
		public Grade(Integer id, String snum, String cnum, String score) {
			super();
			this.id = id;
			Snum = snum;
			Cnum = cnum;
			Score = score;
		}
		
		public Grade(String snum, String cnum, String score) {
			super();
			Snum = snum;
			Cnum = cnum;
			Score = score;
		}
}
