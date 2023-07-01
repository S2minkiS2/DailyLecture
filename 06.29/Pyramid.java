
public class Pyramid {

	public static void main(String[] args) {
		int row = 5; // 피라미드의 높이(줄 수) 설정
		// 공백을 출력하여 정렬
		for (int i = 1; i <= row; i++) { // 피라미드의 각 줄을 나타내는 반복문
			
			for (int j = 1; j <= row -i; j++) {
				System.out.print(" "); //4->3->2->1, 앞에 빈칸의 갯수
			}

			// '*'을 출력하여 피라미드 모양 완성
			for (int k = 1; k <= 2 * i - 1; k++) { //그릴 모형이 삼각형이니까 찍어야 하는 별이 홀수로 나와야 함. 그거 고려해서 한줄에 별이 찍힐 갯수의 범위를 생각해서 식을 세워야 합니다.
				System.out.print("*");  // 1->3->5->7->9
			}
			
			System.out.println(); // 한줄 작업 끝나면 다음 줄로 넘어감
		}

	}

}
