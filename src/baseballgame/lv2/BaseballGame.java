package baseballgame.lv2;

import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    List<Integer> answerList;
    // 생성자에 들어가야 할 것이 무엇일까... 한게임을 만들었을때 시행횟수?

    // 랜덤 정답 번호 생성
    // 1~9까지의 랜덤한 숫자 생성 (중복불가), 숫자의 갯수가 3개가 되면 종료되는 반복문
    public BaseballGame() {
        Set<Integer> AnswerSet = new HashSet<>();
        while (true) {
            int ranNum = random.nextInt(9) + 1;
            AnswerSet.add(ranNum);
            if (AnswerSet.size() == 3) {
                break;
            }
        }
        // hashSet 을 랜덤하게 정렬하기 위해 ArrayList 로 변환
        answerList = new ArrayList<Integer>(AnswerSet);

        // Collections.shuffle 을 통해 list 안의 내용을 랜덤하게 정렬
        Collections.shuffle(answerList);
    }

    public void play() {
        // 1. 유저에게 입력값을 받음.
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            int inputNumber = 0;

            while (true) {
                try {
                    inputNumber = sc.nextInt();
                    isValidNumber(inputNumber);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("올바르지 않은 입력값입니다.");
                    System.out.print("숫자를 입력해주세요: ");
                    sc.nextLine();
                }
                catch (IllegalArgumentException e) {
                    System.out.print(e.getMessage());
                    sc.nextLine();
                }
            }

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

    private boolean isValidNumber(int inputNumber) {
        if (inputNumber >= 100 && inputNumber <= 999) {
            return true;
        } else {
            throw new IllegalArgumentException("올바르지 않은 입력값입니다.\n숫자를 입력해주세요: ");
        }
    }

    public static void startGame() {
        System.out.println("< 환영합니다! 원하시는 번호를 입력해주세요. >");
        System.out.println("1. 게임시작하기 | 2. 게임 기록 보기 | 3. 종료하기");
    }

    public static void finishGame() {
        System.out.println("게임을 종료합니다.");
    }
}