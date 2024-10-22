package baseballgame.lv1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGame baseballGame = new BaseballGame();

        baseballGame.startGame();
        baseballGame.play();
    }
}