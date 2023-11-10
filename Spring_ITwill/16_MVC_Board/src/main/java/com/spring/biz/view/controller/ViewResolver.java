package com.spring.biz.view.controller;

/*
 * ViewResolver 클래스는 Controller(==Service)가 리턴한 String(뷰이름)에 
 * 접두어 (prefix: 경로) 와 접미어(suffix: 확장자)를 결합해서
 * 재요청(응답할) 페이지의 경로와 파일명을 완성해서 리턴한다. 
 * */
public class ViewResolver {
	private String prefix;
	private String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
	//suffix 를 없애서 수동으로 하던가, suffix 설정을 디스패처에서 수정하던가 해서
	// 자유롭게 사용 가능
	
		
}
