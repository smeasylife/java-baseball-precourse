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
    private final InputMessage inputMessage = new InputMessage();
    private final OutputMessage outputMessage = new OutputMessage();
    public void run(){
        AnswerNumber answer = new AnswerNumber(generateAnswerNumber());
        InputNumber inputNumber = new InputNumber(getNumber());

        play(answer.getAnswerNumber(),inputNumber.getInputNumber());

        endOrRestart();
    }

    private List generateAnswerNumber(){
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
    private String getNumber(){
        inputMessage.inputNumMessage();
        String numbers = Console.readLine();
        return numbers;
    }


    private boolean compareAndReturnResult(List answer, List input) {
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < input.size(); i++){
            if (isStrike(answer, input, i)) {
                strike++;
            }
            if (isBall(answer, input, i)) {
                ball++;
            }
        }
        return outputMessage.printResultMessage(ball, strike);
    }

    private boolean isStrike(List answer, List input, int index) {
        if (answer.get(index) == input.get(index)) {
            return true;
        }
        return false;
    }

    private boolean isBall(List answer, List input, int index) {
        if (answer.contains(input.get(index)) && answer.get(index) != input.get(index)) {
            return true;
        }
        return false;
    }

    private void play (List answer, List input){
        while (compareAndReturnResult(answer,input)){
            InputNumber inputNumber = new InputNumber(getNumber());
            input = inputNumber.getInputNumber();
        }
    }

    private void endOrRestart(){
        inputMessage.endOrRestartMessage();
        String num = Console.readLine();
        validate(num);
        if (num == "1"){
            run();
        }
    }
    private void validate(String num){
        isDigit(num);
        checkLengthIs1(num);
    }
    private boolean isDigit(String numbers){
        for(char number: numbers.toCharArray()){
            if(!Character.isDigit(number)){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
    private boolean checkLengthIs1(String numbers){
        if(numbers.length() != 1){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
