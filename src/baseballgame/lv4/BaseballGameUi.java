package baseballgame.lv4;

import java.util.List;

public class BaseballGameUi {
    // 메뉴 UI
    public static void startGame() {
        System.out.println("==============================================================");
        System.out.println("         < 환영합니다! 원하시는 번호를 입력해주세요. >");
        System.out.println("0. 자릿수 설정 | 1. 게임시작하기 | 2. 게임 기록 보기 | 3. 종료하기");
        System.out.println("==============================================================");
    }

    // 게임 종료 UI
    public static void finishGame() {
        System.out.println("< 숫자 야구 게임을 종료합니다 >");
    }

    // 게임 기록 UI
    public static void viewGameRecord(List<BaseballGame> gameRecord) {
        System.out.println("< 게임 기록 보기 >");
        if (gameRecord.isEmpty()) {
            System.out.println("게임 기록이 존재하지 않습니다.");
            System.out.println("메뉴로 돌아갑니다.");
        } else {
            for (int i = 0; i < gameRecord.size(); i++) {
                System.out.println((i+1) + "번째 게임: 시도 횟수 - " + gameRecord.get(i).answerCount);
            }
        }
    }
}
