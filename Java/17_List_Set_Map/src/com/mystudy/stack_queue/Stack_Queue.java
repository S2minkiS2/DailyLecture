package com.mystudy.stack_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
		 큐(Queue) 인터페이스 : 형태상 파이프 형태 (선입선출 : FIFO - First In First Out)
		 - offer(), poll(), peek()
		 스택(Stack) 클래스 : 형태상 바닥이 막힌 통의 형태
		 (후입선출) : LIFO Last in First Out
		 - push(), pop(), peek()
		 */

public class Stack_Queue {
	
	public static void main(String[] args) {
	// 큐(Queue) 인터페이스 - LinkedList 클래스를 큐 형태로 사용
	//	List<String> list =	new LinkedList<String>();
	//ㄴ 이건 리스트를 사용하는 것
		
	Queue<String> queue = new LinkedList<String>();
	queue.offer("1.첫째");
	queue.add("2.둘째"); //add도 가능하나 queue만의 offer를 쓰자
	queue.offer("3.셋째");
	queue.offer("4.넷째");
	queue.offer("5.다섯째");
	
	System.out.println("queue : " + queue);
	System.out.println("개수 : " + queue.size());
	
	
	System.out.println("--- peek() ---");
	//peek(): 현재 사용할 수 있는 데이터를 확인만(읽어오기, 참조, 조회)
	String data = queue.peek(); //읽기. 기존의 데이터 사라지지않음
	System.out.println("peek data : " + data);
	System.out.println("queue.peek() : " + queue.peek());
	System.out.println("개수 : " + queue.size());
	System.out.println("queue : " + queue);
	
	System.out.println("--- poll() ---");
	System.out.println("queue.poll() : " + queue.poll());
	System.out.println("queue.poll() : " + queue.poll());
	System.out.println("queue.remove() : " + queue.remove());
	//remove의 리턴값은 지운 데이터
	System.out.println("queue.poll() : " + queue.poll());
	System.out.println("queue.poll() : " + queue.poll());
	System.out.println("개수 : " + queue.size());
	System.out.println("queue : " + queue.poll());
	//poll은 읽어오고 삭제까지 한다. 꺼내쓰는거니까.
	//없으면 null 리턴한다.
//	System.out.println("queue.remove() : " + queue.remove());
	//데이터 없는데 remove를 또 쓰면 지울거 없다고 오류발생함
	System.out.println("queue.isEmpty() : " + queue.isEmpty());
	
	System.out.println("---- 큐 전체 데이터 추출(사용) -----");
	while (!queue.isEmpty()) { //비어있지않냐?
		//데이터있냐? 있으면 사용해라
		System.out.println("while queue.poll() : " + queue.poll());
	}
	System.out.println("개수 : " + queue.size());
	System.out.println("queue : " + queue);
	
	System.out.println("==================");
	System.out.println("=== 스택(Stack : LIFO - 후입선출");
	Stack<String> stack = new Stack<>();
	stack.push("1. 첫째"); //Stack 메소드의 기능
	stack.add("2. 둘째"); // Vector 메소드
	stack.push("3. 셋째"); //Stack 메소드의 기능
	stack.push("4. 넷째"); //Stack 메소드의 기능
	
	
	System.out.println("stack : " + stack);
	System.out.println("stack.size() : " + stack.size());
	System.out.println("stack.empty() : " + stack.empty());

	System.out.println("--- peek() ----");
	System.out.println("stack.peek() : " + stack.peek());
	System.out.println("stack.peek() : " + stack.peek());
	System.out.println("stack.size() : " + stack.size());
	//참조만
	
	System.out.println("----pop() 꺼내쓰기");
	System.out.println("stack.pop(): " + stack.pop());
	System.out.println("stack.pop(): " + stack.pop());
	System.out.println("stack.pop(): " + stack.pop());
	System.out.println("stack.pop(): " + stack.pop());

	System.out.println("stack : " + stack);
	System.out.println("stack.size() : " + stack.size());
	System.out.println("stack.empty() : " + stack.empty());
	//pop할 것이 없으면 EmptyStackException 예외 발생
	
	System.out.println("---- 스택 전체 데이터 사용(조회)----");
	System.out.println("stack.empty() : " + stack.empty());
	
	while (!stack.empty()) {
		System.out.println(stack.pop());
	}
	System.out.println("stack.size() : " + stack.size());
	System.out.println("stack.empty() : " + stack.empty());
	
	
	}

}
