package baseballgame.lv1;

import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    List<Integer> answerList;

    // 랜덤 정답 번호 생성
    // 1~9까지의 랜덤한 숫자 생성 (중복불가), 숫자의 갯수가 3개가 되면 종료되는 반복문
    public BaseballGame() {
        Set<Integer> answerSet = new HashSet<>();
        while (true) {
            int ranNum = random.nextInt(9) + 1;
            answerSet.add(ranNum);
            if (answerSet.size() == 3) {
                break;
            }
        }
        // hashSet 을 랜덤하게 정렬하기 위해 ArrayList 로 변환
        answerList = new ArrayList<Integer>(answerSet);

        // Collections.shuffle 을 통해 list 안의 내용을 랜덤하게 정렬
        Collections.shuffle(answerList);
    }

    public void play() {
        // 1. 유저에게 입력값을 받음.
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            int inputNumber = sc.nextInt();

            // 2. 스트라이크,볼 개수 계산
            List<Integer> inputList = changeAnswerToList(inputNumber);

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (answerList.get(i).equals(inputList.get(j))) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }

            if (strike == 0 && ball == 0) {
                System.out.println("아웃!!!");
            } else {
                System.out.println(strike + "스트라이크!  " + ball + "볼!");
            }

            if (strike == 3) {
                System.out.println("축하드립니다! 정답입니다!!!");
                break;
            }
        }
    }

    // 입력한 값을 ArrayList로 변경하는 메서드
    private List<Integer> changeAnswerToList(int answer) {
        List<Integer> list = new ArrayList<Integer>();

        while (answer > 0) {
            int tempNum = answer % 10;
            answer /= 10;
            list.add(tempNum);
        }

        Collections.reverse(list);
        return list;
    }

    // 게임시작
    public static void startGame() {
        System.out.println("< 게임을 시작합니다 >");
    }

    // 게임종료
    public static void finishGame() {
        System.out.println("게임을 종료합니다.");
    }
}