package com.mystudy.array4_2dim;

public class ArrayTwoDimension {

	public static void main(String[] args) {
		// 2차원 배열 선언 및 객체를 생성
		// 타입[][] 변수명 = new 타입[크기값][크기값];
		// 타입[][] 변수명 = {{..}, {..}, {..}, {..}, {..}};
		
		int[][] nums = {{10,20}, // 10: nums[0][0], 20: nums[0][1]
						{30,40}, // 30: nums[1][0], 40: nums[1][1]
						{50,60}  // 50: nums[2][0], 60: nums[2][1]
						}; // 바로 숫자가 올 순 없습니다. 배열이 와야 해요.
		
		System.out.println(nums.length); //3개의 배열이 존재
		System.out.println(nums[0].length); //2개의 인스턴스값이 존재
		System.out.println(nums); 
		System.out.println(nums[0]); //주소값
		System.out.println(nums[0][0]); //인스턴스값
		
		System.out.println("----------------------");
		
		//nums에 있는 첫번째 데이터(1차원배열) 화면 출력
		System.out.println("nums[0]: " + nums[0]);
		for (int i = 0; i < nums[0].length; i++) {
			System.out.print(nums[0][i] + " ");
		}
		System.out.println();
		
		//nums에 있는 두번째 데이터(1차원배열) 화면 출력
		System.out.println("nums[1]: " + nums[1]);
		for (int i = 0; i < nums[1].length; i++) {
			System.out.print(nums[1][i] + " ");
		}
		System.out.println();
		
		//nums에 있는 세번째 데이터(1차원배열) 화면 출력
		System.out.println("nums[2]: " + nums[2]);
		for (int i = 0; i < nums[2].length; i++) {
			System.out.print(nums[2][i] + " ");
		}
		System.out.println();
		System.out.println("----------------------");
		
		System.out.println("=== 이중 for문 2차원 배열 데이터 for반복문으로 ===");
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println("nums - " + i + " : " + nums[i]);
			for (int idx = 0; idx < nums[i].length; idx++) {
				System.out.print(nums[i][idx] + " ");
			}
			System.out.println();
			System.out.println("----------------------");
		}
		
		System.out.println("======================");
		int[][] numsBackup = nums.clone(); // 2차원 배열에서는 클론처리 하면 안된다. 1차원 배열단위에서 클론처리 해야 한다.
		// 2차원 배열에서 clone 메서드를 쓰면, 주소값을 복사해오기 때문이다. 마치 참조변수처럼...
		// 주의 요망
		System.out.println("nums : " + nums); //두개는 
		System.out.println("numsBackup : " + numsBackup); //물리적으로 분리된 객체다.
		System.out.println("nums == numsBackup: " + (nums == numsBackup));
		System.out.println("----------------------");
		
		System.out.println("nums[0]: " + nums[0]); //값이 같다는 의미
		System.out.println("numsBackup[0]: " + numsBackup[0]);
		System.out.println("nums[0] == numsBackup[0]: " + (nums[0] == numsBackup[0]));
		System.out.println("----------------------");
		
		nums[0][0] = 999;
		System.out.println("nums[0][0] : " + nums[0][0]);
		System.out.println("numsBackup[0][0] : " + numsBackup[0][0]);
		
		
		
	}

}
