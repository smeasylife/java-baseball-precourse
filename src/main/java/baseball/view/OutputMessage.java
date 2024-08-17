package baseball.view;

public class OutputMessage {
    public boolean printResultMessage(int ball, int strike) {
        if (strike == 3) {
            strikeAll();
            return false;
        } else if (ball == 0 && strike == 0) {
            nothing();
            return true;
        } else {
            ballAndStrike(ball, strike);
            return true;
        }
    }

    public static void strikeAll(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void nothing(){
        System.out.println("낫싱");
    }

    public static void ballAndStrike(int ball, int strike){
        System.out.printf("%d볼 %d스트라이크",ball,strike);
        System.out.println();
    }
}
