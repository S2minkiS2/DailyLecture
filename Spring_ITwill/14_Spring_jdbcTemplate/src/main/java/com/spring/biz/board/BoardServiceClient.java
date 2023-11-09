package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		System.out.println("---- 스프링 컨테이너 구동 전 -----");
		//1. 스프링 컨테이너 구동(스프링 설정 파일 읽어서)
			GenericXmlApplicationContext container
				= new GenericXmlApplicationContext("applicationContext.xml");
			//-> 스프링 컨테이너 만듦
			
		//2. 스프링 컨테이너 사용(Bean그래프에 있는 것 갖고오기 -> 형변환)
			BoardService boardService = (BoardService) container.getBean("boardService");
			System.out.println("boardService : " + boardService);
		
			BoardVO vo = new BoardVO();
			vo.setTitle("스프링제목-1109");
			vo.setWriter("개발자-신민기");
			vo.setContent("테스트 내용- 스프링 어렵다");
			
			boardService.insertBoard(vo);
			
			List<BoardVO> list = boardService.getBoardList();
			for(BoardVO board : list) {
				System.out.println("board : " + board);
			}
			
			System.out.println("스프링 컨테이너를 종료합니다");
		//3. 스프링 컨테이너 종료
			container.close();
		
	}

}
