package baseballgame.lv4;

import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    List<Integer> answerList;
    List<BaseballGame> gameRecord = new ArrayList<BaseballGame>();
    int answerCount;

    // 랜덤 정답 번호 생성
    // 1~9까지의 랜덤한 숫자 생성 (중복불가), 숫자의 갯수가 ballQuantity 개가 되면 종료되는 반복문
    public BaseballGame(int ballQuantity) {
        Set<Integer> answerSet = new HashSet<>();
        while (true) {
            int ranNum = random.nextInt(9) + 1;
            answerSet.add(ranNum);
            if (answerSet.size() == ballQuantity) {
                break;
            }
        }
        // hashSet 을 정렬하기 위해 ArrayList 로 변환
        answerList = new ArrayList<Integer>(answerSet);

        // Collections.shuffle 을 통해 list 안의 내용을 랜덤하게 정렬
        Collections.shuffle(answerList);
    }

    public void play(int ballQuantity) {
        while (true) {
            // 1. 유저에게 입력값을 받음.
            int inputNumber = 0;
            System.out.print("숫자를 입력해주세요: ");

            while (true) {
                try {
                    inputNumber = sc.nextInt();
                    isValidNumber(inputNumber, ballQuantity);
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("올바르지 않은 입력값입니다.\n" + ballQuantity + "자리의 숫자를 입력해주세요: ");
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.print("올바르지 않은 입력값입니다.\n" + ballQuantity + "자리의 숫자를 입력해주세요: ");
                    sc.nextLine();
                }
            }

            // 2. 스트라이크,볼 개수 계산
            List<Integer> inputList = changeAnswerToList(inputNumber);

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < ballQuantity; i++) {
                for (int j = 0; j < ballQuantity; j++) {
                    if (answerList.get(i).equals(inputList.get(j))) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }
            // 게임시도 횟수 증가
            answerCount++;

            // 입력 값에 대한 게임 결과
            if (strike == 0 && ball == 0) {
                System.out.println("아웃!!!");
            } else {
                System.out.println(strike + "스트라이크!  " + ball + "볼!");
            }

            if (strike == ballQuantity) {
                System.out.println("축하드립니다! 정답입니다!!!");
                break;
            }
        }
    }

    // 게임난이도 조절 ( 볼 갯수 설정 )
    public int setBallQuantity() {
        System.out.println("설정하고자 하는 자리수를 입력하세요.");
        int ballQuantity = 0;
        while (true) {
            try {
                int quantity = sc.nextInt();
                if (quantity == 3 || quantity == 4 || quantity == 5) {
                    ballQuantity = quantity;
                    System.out.println(ballQuantity + "자리수 난이도로 설정되었습니다.");
                    break;
                } else {
                    throw new InputMismatchException("올바르지 않은 입력값입니다.\n'3~5' 사이의 숫자를 입력해주세요!");
                }
            } catch (InputMismatchException e) {
                System.out.println("올바르지 않은 입력값입니다.\n'3~5' 사이의 숫자를 입력해주세요!");
                sc.nextLine();
            }
        }
        return ballQuantity;
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

    // 사용자의 입력값이 유효한지 검사
    private boolean isValidNumber(int inputNumber, int ballQuantity) {
        List<Integer> inputList = changeAnswerToList(inputNumber);
        Set<Integer> inputSet = new HashSet<Integer>(inputList);

        if (ballQuantity == inputList.size()) {
            if (inputList.size() == inputSet.size()) {
                return true;
            } else {
                throw new IllegalArgumentException("올바르지 않은 입력값입니다.\n중복되지 않은 숫자를 입력해주세요: ");
            }
        } else {
            throw new InputMismatchException("올바르지 않은 입력값입니다.\n" + ballQuantity + "자리의 숫자를 입력해주세요: ");
        }
    }
}