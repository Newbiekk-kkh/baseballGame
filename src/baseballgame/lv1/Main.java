package baseballgame.lv1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.startGame();
            try {
                int select = sc.nextInt();
                switch (select) {
                    case 1:
                        baseballGame.play();
                        break; // 게임 시작 후 프로그램 종료

                    case 2:
                        System.out.println("아직 구현되지 않은 기능입니다.");
                        baseballGame.finishGame();  // finishGame 메서드 호출
                        return; // 프로그램 종료

                    case 3:
                        baseballGame.finishGame();  // finishGame 메서드 호출
                        return; // 프로그램 종료

                    default:
                        throw new IllegalArgumentException("잘못된 입력값입니다. 다시 입력해주세요.\n");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}