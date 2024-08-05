package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;
import baseball.view.InputMessage;
import baseball.view.OutputMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final InputMessage inputMessage = new InputMessage();
    private static final OutputMessage outputMessage = new OutputMessage();
    public static void run(){
        AnswerNumber answer = new AnswerNumber(generateNumber());
        InputNumber inputNumber = new InputNumber(getNumber());

        play(answer.getAnswerNumber(),inputNumber.getInputNumber());

        endOrRestart();
    }

    private static List generateNumber(){
        List<Integer> numList = new ArrayList<>();
        numList.add(Randoms.pickNumberInRange(1,9));

        while (numList.size() < 3){
            int num = Randoms.pickNumberInRange(1,9);
            if (!numList.contains(num)){
                numList.add(num);
            }
        }
        return numList;
    }
    private static String getNumber(){
        inputMessage.inputNumMessage();
        String numbers = Console.readLine();
        return numbers;
    }
    public static boolean compareAndReturnResult(List answer, List input){
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(answer.get(i) == input.get(j) && i == j){
                    strike++;
                } else if (answer.get(i) == input.get(j) && i != j) {
                    ball++;
                }
            }
        }
        return outputMessage.printResultMessage(ball,strike);
    }
    private static void play(List answer, List input){
        while (true){
            if (compareAndReturnResult(answer,input)){
                break;
            }
        }
    }

    private static void endOrRestart(){
        inputMessage.endOrRestartMessage();
        String num = Console.readLine();
        validate(num);
        if (num == "1"){
            run();
        }
    }
    private static void validate(String num){
        isDigit(num);
        checkLengthIs1(num);
    }
    private static boolean isDigit(String numbers){
        for(char number: numbers.toCharArray()){
            if(!Character.isDigit(number)){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
    public static boolean checkLengthIs1(String numbers){
        if(numbers.length() != 1){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
