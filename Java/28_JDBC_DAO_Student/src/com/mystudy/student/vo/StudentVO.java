package com.mystudy.student.vo;

//Student, Student,VO, StudentVo, StudentDTO, StudentDto...
public class StudentVO {
	private String id; //데이터를 가져다 쓸 VO 정의
	private String name; //외부에서 direct 접근 못하게 private으로 숨긴다
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	
	
	public StudentVO(String id, String name, int kor, int eng, int math, int tot, double avg) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = tot;
		this.avg = avg;
		computeTotAvg(); //tot, avg 자동 계산해줌
	}



	

	public StudentVO(String id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg();
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getKor() {
		return kor;
	}



	public void setKor(int kor) {
		this.kor = kor;
	}



	public int getEng() {
		return eng;
	}



	public void setEng(int eng) {
		this.eng = eng;
	}



	public int getMath() {
		return math;
	}



	public void setMath(int math) {
		this.math = math;
	}



	public int getTot() {
		return tot;
	}



	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getAvg() {
		// TODO Auto-generated method stub
		return 0;
	}



	
	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot="
				+ tot + ", avg=" + avg + "]";
	}



	public void computeTotAvg() {
		tot = kor + eng + math;
		avg = Math.round(tot * 100 / 3.0 / 100.0); //소수점 둘째자리 
	}






	
	
	

	
}




