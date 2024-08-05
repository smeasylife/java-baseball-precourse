package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.InputNumber;
import baseball.view.InputMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final InputMessage inputMessage = new InputMessage();
    public void run(){
        AnswerNumber answer = new AnswerNumber(generateNumber());
        InputNumber inputNumber = new InputNumber(getNumber());
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


}
