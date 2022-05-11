package com.baseball.core;

import java.util.ArrayList;
import java.util.List;

import com.baseball.core.Game.GenerateRandomNumber;
import com.baseball.core.Game.Intermission;
import com.baseball.core.Game.JudgeYourGuess;
import com.baseball.core.Game.PlayerInput;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CoreApplication.class, args);
		//java로 이루어진 코드이므로 스프링을 사용하지않는다
		GenerateRandomNumber genNumber = new GenerateRandomNumber();
		PlayerInput player = new PlayerInput();
		Intermission intermission = new Intermission();
		JudgeYourGuess judge = new JudgeYourGuess();
		boolean isPlaying = true;
		int attemps = 0;

		while(isPlaying) {
			List<Integer> newGame = genNumber.pickNumber();
			String result = "";

			while (!result.equals("Correct! You Win!")) {
				result = judge.getResult(newGame, player.getPlayerNumber());
				System.out.println(result);
				attemps++;
			}
			System.out.print("시도한 횟수 : " + attemps + "\n");

			isPlaying = intermission.askRestart();

			if (isPlaying == true)
				attemps = 0;
		}
	}
}
