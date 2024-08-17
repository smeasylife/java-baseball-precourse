package baseball.model;

import java.util.List;

public class AnswerNumber {
    private List<Integer> answerNumber;

    public AnswerNumber(List answer){

        this.answerNumber = answer;
    }
    public List<Integer> getAnswerNumber(){
        return answerNumber;
    }
}
