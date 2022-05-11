package com.baseball.core.Game;

import java.util.List;

public class CalcYourGuess {
    //플레이어의 숫자와 게임에서 배정된 숫자를 비교해 판단하는 클래스

    /*
    우선 맞은 갯수를 확인하는 메서드
    필요한 정보는 strike, ball이지만
    한번에 내보내는 것은 어려우므로
    두번에 걸쳐 계산한다
    */
    public int getCorrectCount(List<Integer> gameNumber, List<Integer> playerNumber){
        int correct = 0;

        for (int i = 0; i < 3; i++) {
            if (gameNumber.contains(playerNumber.get(i)))
            correct++;
        }

        return correct;
    }

    public int getStrikeCount(List<Integer> gameNumber, List<Integer> playerNumber){
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (gameNumber.get(i).equals(playerNumber.get(i)))
            strike++;
        }

        return strike;
    }
}
