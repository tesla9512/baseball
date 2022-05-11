package com.baseball.core.Game;

import java.util.Scanner;

public class Intermission {
    public boolean askRestart() {
        Scanner sc = new Scanner(System.in);

        System.out.print("게임을 다시 시작하려면 1, 종료하려면 1을 제외한 아무 값이나 입력하세요 : ");

        String reply = sc.nextLine();
        //sc.close();
        
        if (reply.equals("1"))
            return true;
        else
            return false;
    }
}
