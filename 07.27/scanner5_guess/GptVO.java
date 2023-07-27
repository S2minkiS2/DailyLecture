package com.mystudy.scanner5_guess;

public class GptVO {

    private int comNum;
    private int myNum;
    private int chanceNum;

    // 생성자
    public GptVO() {
        comNum = (int) (Math.random() * 99) + 1;
        myNum = 0;
        chanceNum = 0;
    }

    // Getter 메서드
    public int getComNum() {
        return comNum;
    }

    public int getMyNum() {
        return myNum;
    }

    public int getChanceNum() {
        return chanceNum;
    }

    // 게임 로직 메서드
    public boolean guessMyNum(int num) {
        myNum = num;
        if (myNum > comNum) {
            System.out.println("더 낮은 숫자를 불러보세요.");
            chanceNum++;
        } else if (myNum < comNum) {
            System.out.println("더 높은 숫자를 불러보세요.");
            chanceNum++;
        } else {
            System.out.println("정답입니다!");
            chanceNum++;
            return true; // 정답을 맞춘 경우 true 반환
        }
        return false; // 정답을 맞추지 못한 경우 false 반환
    }


}


