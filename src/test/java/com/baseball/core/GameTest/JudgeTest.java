package com.baseball.core.GameTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;

import com.baseball.core.Game.CalcYourGuess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgeTest {
    CalcYourGuess calc;

    @BeforeEach
    void setUp() {
        calc = new CalcYourGuess();
    }
    
    @Test
    @DisplayName("맞춘 숫자의 수 확인")
    void correct(){
        assertThat(3).isEqualTo(calc.getCorrectCount(Arrays.asList(1,2,3), Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("스트라이크의 수 확인")
    void strike(){
        assertThat(2).isEqualTo(calc.getCorrectCount(Arrays.asList(1,2,3), Arrays.asList(9,2,3)));
    }
}
