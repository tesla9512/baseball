package com.baseball.core.Game;

import java.util.List;

public class JudgeYourGuess {
    //플레이어의 선택을 판단하여 결과를 반환하는 클래스

    public String getResult(List<Integer> gameNumber, List<Integer> playerNumber) {
        if (playerNumber == null)
            return "!! 1-9까지의 숫자를 입력하세요.";

        CalcYourGuess calc = new CalcYourGuess();

        int correct = calc.getCorrectCount(gameNumber, playerNumber);
        int strike = calc.getStrikeCount(gameNumber, playerNumber);

        if (correct == 0)
            return "Out";
        else if (strike == 3)
            return "Correct! You Win!";
        else if (strike == 0)
            return (correct - strike) + " Balls";
        else
            return strike + " Strikes, " + (correct - strike) + " Balls";
    }
}
