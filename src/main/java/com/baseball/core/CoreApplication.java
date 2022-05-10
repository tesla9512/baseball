package com.baseball.core;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CoreApplication.class, args);
		//java로 이루어진 코드이므로 스프링을 사용하지않는다

		//세자리 숫자 맞추기 뭘로 할 것인가

		//1. 숫자로 처리한다
		//나의 입력 매 순간 형변환 하고 자릿수별 계산 들어감

		//2. 문자열로 처리한다
		//나의 입력 매 순간 분할함

		//2번의 절차가 1번보다 적다고 판단하여 2번으로 간다

		

		Scanner scanner = new Scanner(System.in);

		int[] numbers = {1,2,3,4,5,6,7,8,9};

		String[] goal = new String[3];

		for (int i = 0; i < 90; i++) {
			int targetA = ThreadLocalRandom.current().nextInt(0, 8);
			int targetB = ThreadLocalRandom.current().nextInt(0, 8);

			if (targetA == targetB)
				targetB = ThreadLocalRandom.current().nextInt(0, 8);

			int tmp = numbers[targetA];
			numbers[targetA] = numbers[targetB];
			numbers[targetB] = tmp;
		}
		goal[0] = Integer.toString(numbers[0]);
		goal[1] = Integer.toString(numbers[1]);
		goal[2] = Integer.toString(numbers[2]);

		int status = 0; //1 : 성공, 2 : 실패


		for (int i = 0; i < 10; i++) {
			System.out.print(i+1 + "번째 시도 : ");

			try {
			int input = scanner.nextInt();
			String[] shoot = Integer.toString(input).split("");
		
			int strike = 0;
			int ball = 0;

			//반복문 순회하면서 스트라이크, 볼 구분하기
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					if (goal[j].equals(shoot[j2])){
						if (j == j2)
							strike++;
						else
							ball++;
					}
				}
			}

			if (strike == 3){
				status = 1;
				break;
			}
			else if (strike == 0 && ball == 0) {
				System.out.println("four ball");
			}
			else {
				System.out.println(strike + " strikes, " + ball + " balls\n");

				if (i == 9)
					status = 2;
			}

			}
			catch (IllegalArgumentException e) {
				// System.out.println("잘못된 입력으로 게임이 중단되었습니다.");
				 System.out.println(e.getMessage());
				break;
			}
		}

		switch(status){
			case 1:
			System.out.println("정답을 맞혔습니다.");
			break;
			case 2:
			System.out.print("정답을 맞히지 못했습니다. 정답 : ");

			for (String string : goal) {
				System.out.print(string);
			}

			System.out.println();
			break;
		}

		scanner.close();
	}
}
