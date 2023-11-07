package com.spring.biz.board;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("배고파요");
		vo.setWriter("신민기");
		vo.setContent("오늘 좀 힘드네요 아닌거 같은데");
		
		BoardDAO dao = new BoardDAO();
		
		dao.insertBoard(vo);

		vo.setSeq(1);
		BoardVO board = dao.getBoard(vo);
		System.out.println("board : " + board);
	}

}
