package com.baseball.core.GameTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;

import com.baseball.core.Game.CalcYourGuess;
import com.baseball.core.Game.JudgeYourGuess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class caseTest {
    CalcYourGuess calc;
    JudgeYourGuess judge;

    @BeforeEach
    void setUp() {
        calc = new CalcYourGuess();
        judge = new JudgeYourGuess();
    }

    @Test
    @DisplayName("3 Strikes, Win")
    void isWin() {
        assertThat("Correct! You Win!").isEqualTo(judge.getResult(Arrays.asList(1,2,3), Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("Out")
    void isOut() {
        assertThat("Out").isEqualTo(judge.getResult(Arrays.asList(1,2,3), Arrays.asList(4,5,6)));
    }

    @Test
    @DisplayName("3 Balls")
    void isThreeBall() {
        assertThat("3 Balls").isEqualTo(judge.getResult(Arrays.asList(1,2,3), Arrays.asList(2,3,1)));
    }
}
