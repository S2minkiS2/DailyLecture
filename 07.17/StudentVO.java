package com.mystudy.bean_vo;

// 자바빈 (Java Bean) 형태의 클래스 작성
// VO (Value Object) : 값(데이터)을 저장하기 위한 클래스(객체) - Oxxx, OxxxVO, OxxxVo
// DTO (Data Transfer Object) : 값(데이터)을 저장해서 전달하기 위한 클래스(객체)
//	Oxxxx, OxxxDTO, OxxxDto
public class StudentVO {
	//필드(변수)선언-----------------------private
	//성명 - name : String
	//국어점수 - kor : int
	//영어점수 - eng : int
	//수학점수 - math : int
	//총점 - tot : int
	//평균 - avg : double
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	
	
	
	//생성자 작성-------------------------public
	//생성자 - 성명, 국어, 영어, 수학 점수를 입력받는 생성자
	
	StudentVO(){
		name = "기본생성자 테스트";
		System.out.println(name);
	}; //기본생성자
	
	StudentVO(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		setTot();
//		this.tot = getTot();
		setAvg();
//		this.avg = getAvg();
		
		System.out.println(this.name + "\t" + this.kor + "\t" + this.eng + "\t" + this.math + "\t" + tot + "\t" + avg);
	}
	
	
	
	
	//메소드 작성-------------------------public
	//setters, getters 모두 작성
	
	public void setTot() {
		this.tot = kor+eng+math; // 여기에 this. 를 붙인것과 안붙인 것은 무슨 차이가 있을까?
	}
	public void setAvg() {
		this.avg = tot*100/3/100.0;
	}
	
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	
	
	
	
}
