package baseballgame.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BaseballGame> gameRecord = new ArrayList<BaseballGame>();

        while (true) {
            BaseballGame baseballGame = new BaseballGame();
            BaseballGameUi.startGame();
            try {
                int select = sc.nextInt();
                switch (select) {
                    case 1:
                        baseballGame.play();
                        gameRecord.add(baseballGame);
                        break; // 게임 시작 후 프로그램 종료

                    case 2:
                        BaseballGameUi.viewGameRecord(gameRecord);
                        break;

                    case 3:
                        BaseballGameUi.finishGame();
                        return; // 프로그램 종료

                    default:
                        throw new IllegalArgumentException("올바른 숫자를 입력해주세요!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}