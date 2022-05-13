package com.baseball.core.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerInput {
    // 게임의 주요 조작을 담당하는 클래스

    /*
     * 입력된 값을 변환하는 메서드
     * 잘못된 입력이 있는지 판단하는 절차를 거쳐 정상 범주에 해당되는 입력값만 전달할 수 있게 한다
     */
    public List<Integer> getPlayerNumber() {
        Scanner sc = new Scanner(System.in);

        List<Integer> playerNumber = new ArrayList<>();

        System.out.print("예상되는 3자리의 숫자를 입력하시오 : ");
        String input = sc.nextLine();
        // sc.close();

        if (input.length() != 3 || !input.matches("[1-9][1-9][1-9]")) {
            return null;
        } else {
            for (String number : input.split("")) {
                playerNumber.add(Integer.parseInt(number));
            }
            return playerNumber;
        }
    }
}
