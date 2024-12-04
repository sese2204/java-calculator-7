package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String requestInput(){
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input){
        if (input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("[ERROR] 입력 값이 비어있습니다.");
        }
    }
}
