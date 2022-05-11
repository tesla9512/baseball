package com.baseball.core.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumber {
    //게임에 이용할 1부터 9까지의 임의의 숫자를 3개 골라 게임에 사용하는 클래스
    static int[] numbers = {1,2,3,4,5,6,7,8,9};
    /*
    순차적으로 배치된 / 혹은 이미 섞은 배열을 섞는 메서드
    랜덤으로 결정된 색인 번호를 맞바꾸는 것을 반복하는 것으로
    아래의 메서드 pickNumber를 호출할 때 어떤 색인번호를 선택하든 
    무작위로 섞인 값을 기대할 수 있다
    */
    public void shuffleNumber(int attemps) {
        for (int i = 0; i < attemps; i++) {
			int targetA = ThreadLocalRandom.current().nextInt(0, 9);
			int targetB = ThreadLocalRandom.current().nextInt(0, 9);

			int tmp = numbers[targetA];
			numbers[targetA] = numbers[targetB];
			numbers[targetB] = tmp;
		}
    }

    public List<Integer> pickNumber() {
        List<Integer> gameNumber = new ArrayList<>();

        shuffleNumber(ThreadLocalRandom.current().nextInt(45, 255));

        for (int i = 0; i < 3; i++) {
            gameNumber.add(numbers[i]);
        }

        return gameNumber;
    }
}
