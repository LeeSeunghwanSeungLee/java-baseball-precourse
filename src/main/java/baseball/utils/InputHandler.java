package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {

    public List<Integer> makeNumbers() {
        return TypeTransformer.changeString2List(makeInput());
    }

    private String makeInput() {
        String input = Console.readLine();

        InputValidator.validateInputType(input);
        InputValidator.validateIsEmpty(input);
        InputValidator.validateSize(input);
        InputValidator.validateNumberRange(input);
        InputValidator.validateEqualNumber(input);

        return input;
    }
}
