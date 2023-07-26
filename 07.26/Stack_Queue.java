package com.mystudy.stack_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
큐(Queue) 인터페이스 : 형태상 파이프 형태 (선입선출 : FIFO - First In First Out)
	- offer(), poll(), peek()
스택(Stack) 클래스 : 형태상 바닥이 막힌 통의 형태 (후입선출 : LIFO - Last In First Out)
	- push(), pop(), peek()
*/
public class Stack_Queue {

	public static void main(String[] args) {
		// 큐 인터페이스 - LinkedList 클래스를 Queue 형태로 사용
		// List<String> list = new LinkedList<String>(); //문자열을 저장하는 리스트
		Queue<String> queue = new LinkedList<String>(); //queue 는 collection 기능도 사용 가능해요.
		queue.offer("1.첫째뽀잉");
		queue.add("2.둘째뿌잉");
		queue.offer("3.셋째뚜루");
		queue.offer("4.넷째뚜뚱");
		queue.offer("5.다섯째진지");
		
		
		System.out.println("queue : " + queue);
		System.out.println("갯수 : " + queue.size()); //collection 의 size()
		
		//peek() : 현재 사용할 수 있는 데이터를 확인만(읽어오기, 조회)
		String data = queue.peek(); //뭘 쓸 수 있는지 검색
		System.out.println("peek() data : " + data); // 첫째뽀잉이 나온다. FIFO
		System.out.println("queue.peek() : " + queue.peek()); 
		
		
		System.out.println("------------------------- poll() ------------------------");
//		System.out.println("queue.poll() : " + queue.poll()); //읽어오고 원본에서는 삭제.
//		System.out.println("queue.remove() : " + queue.remove()); //내부적으로 삭제
		System.out.println("queue.poll() : " + queue.poll()); 
		System.out.println("queue.poll() : " + queue.poll()); 
		System.out.println("queue.poll() : " + queue.poll()); 
		System.out.println("queue.poll() : " + queue.poll()); //없으면 null 을 리턴한다.
//		System.out.println("queue.remove() : " + queue.remove()); //없으면 Exception 발생 = NoSuchElementException
		// 이왕이면 remove보다 poll을 쓰자.
		
		System.out.println("갯수 : " + queue.size());
		System.out.println("queue : " + queue);
		System.out.println("queue.isEmpty() : " + queue.isEmpty()); // 아무것도 없어서 true
		
		System.out.println("---------------------- 큐 전체 데이터 추출(사용) -------------------------");
		while (!queue.isEmpty()) {
			//데이터 사용하기
			System.out.println("queue.poll() : " + queue.poll());
		}
		System.out.println("갯수 : " + queue.size());
		System.out.println("queue.isEmpty() : " + queue.isEmpty());
		
		System.out.println("\n==================================================================");
		System.out.println("---------------------- 스택 : LIFO - 후입선출 -------------------------");
		Stack<String> stack = new Stack<>();
		stack.push("1.첫째뽀잉"); // stack 메서드
		stack.add("2.둘째뿌잉"); // vector 메서드
		stack.push("3.셋째뚜루"); // stack 메서드
		stack.push("4.넷째뚜뚱"); // stack 메서드
		
		System.out.println("stack : " + stack);
		System.out.println("stack.size() : " + stack.size());
		System.out.println("stack.empty() : " + stack.empty());
		System.out.println("stack.peek() : " + stack.peek());
		
		System.out.println("------------------ peek() 사용할 수 있는 데이터 확인(참조) -----------------");
		System.out.println("stack.peek() : " + stack.peek());
		System.out.println("stack.peek() : " + stack.peek());
		System.out.println("stack.size() : " + stack.size());
		
		System.out.println("---------------- pop() 꺼내쓰기 -없으면 Exception 발생 ----------------------");
		System.out.println("stack.pop() : " + stack.pop());
		System.out.println("stack.pop() : " + stack.pop());
		System.out.println("stack : " + stack);
		System.out.println("stack.size() : " + stack.size());
//		System.out.println("stack.pop() : " + stack.pop());
//		System.out.println("stack.pop() : " + stack.pop());
		//System.out.println("stack.pop() : " + stack.pop()); //poll은 null이 떴지만, pop은 데이터가 없으면 Exception 발생
		
		System.out.println("------------------ 스택 전체 데이터 사용 -----------------");
		System.out.println("stack.empty() : " + stack.empty());
		
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println("stack.size() : " + stack.size());
		System.out.println("stack.empty() : " + stack.empty());
		
		
		
		
		
		
	}

}
