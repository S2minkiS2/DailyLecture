package com.mystudy.map2_ExamVO;

public class StudentVO {
	private String studentID;
	private String name;
	private int eng;
	private int com;
	private int music;
	private int tot;
	private double avg;
	
	
	//생성자 마음대로 만들기
	public StudentVO(String studentID, String name, int eng, int com, int music) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.eng = eng;
		this.com = com;
		this.music = music;
		computeTotAvg();
	}


	//메소드 마음대로 만들기
	
	public String printData() {
		return studentID + "\t"
				+ name + "\t"
				+ eng + "\t"
				+ com + "\t"
				+ music + "\t"
				+ tot + "\t"
				+ avg ;
	}

	public String getstudentID() {
		return studentID;
	}


	public void setstudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
		computeTotAvg(); //점수가 바뀌면 총점, 평균이 자동으로 다시 계산 되게끔~
	}
	
	
	public int getCom() {
		return com;
	}


	public void setCom(int com) {
		this.com = com;
		computeTotAvg();
	}


	public int getMusic() {
		return music;
	}


	public void setMusic(int music) {
		this.music = music;
		computeTotAvg();
	}


	public int getTot() {
		return tot;
	}


//	public void setTot(int tot) { // 토탈과 평균을 직접 주입하지 못하게 막기. 오직 computeTotAvg()를 써야 조절할 수 있다
//		this.tot = tot;
//	}


	public double getAvg() {
		return avg;
	}


//	public void setAvg(double avg) { // 토탈과 평균을 직접 주입하지 못하게 막기. 오직 computeTotAvg()를 써야 조절할 수 있다
//		this.avg = avg;
//	}
	
	public void computeTotAvg() {
		tot =  eng + com + music;
		avg = tot *100/3/100.0;
	}
	
	
	

	@Override
	public String toString() {
		return "이름 : " + name + ", 학생번호 : " + studentID + ", 영어 : " + eng + ", 컴퓨터 : "
				+ com + ", 음악 : " + music + ", 총점 : " + tot + ", 평균 : " + avg + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentID == null) ? 0 : studentID.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		if (studentID == null) {
			if (other.studentID != null)
				return false;
		} else if (!studentID.equals(other.studentID))
			return false;
		return true;
	}


	

	

	
	
	
	
	
}
