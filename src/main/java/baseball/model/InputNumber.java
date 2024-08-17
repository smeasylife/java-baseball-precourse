package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    private List inputNumber;

    public InputNumber(String input){
        validate(input);
        List<Integer> numList = stringToIntList(input);
        this.inputNumber = numList;
    }
    public List<Integer> getInputNumber(){
        return inputNumber;
    }
    private List stringToIntList(String numbers){
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; numbers.length() > i; i++){
            numList.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
        }
        return numList;
    }

    private void validate(String numbers){
        isDigit(numbers);
        checkLengthIs3(numbers);
    }

    private boolean isDigit(String numbers){
        for(char number: numbers.toCharArray()){
            if(!Character.isDigit(number)){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
    public boolean checkLengthIs3(String numbers){
        if(numbers.length() != 3){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
