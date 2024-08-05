package baseball.controller;

import baseball.model.AnswerNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public static void run(){
        AnswerNumber answer = new AnswerNumber(generateNumber());
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
}
