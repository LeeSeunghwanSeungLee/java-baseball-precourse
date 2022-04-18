package baseball.utils;

import baseball.config.BaseballConfig;
import baseball.config.ErrorMessageConfig;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {
    private static InputHandler inputHandler = null;

    private InputHandler() {}

    public static InputHandler getInstance() {
        if (inputHandler == null)
            inputHandler = new InputHandler();
        return inputHandler;
    }

    public List<Integer> makeNumberList(String input) {
        validPipeline(input);
        return TypeTransformer.changeString2List(input);
    }

    private void validPipeline(String input) {
        InputValidator.validateInputType(input);
        InputValidator.validateIsEmpty(input);
        InputValidator.validateSize(input);
        InputValidator.validateNumberRange(input);
        InputValidator.validateEqualNumber(input);
    }

    public boolean isRegame(String input) {
        InputValidator.validateIsEmpty(input);
        if (input.equals(BaseballConfig.Regame.getConfig()))
            return true;
        if (input.equals(BaseballConfig.EndGame.getConfig()))
            return false;
        throw new IllegalArgumentException(ErrorMessageConfig.InputExactNumber.getErrorMessage());
    }
}
