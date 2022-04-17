package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {

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
        if (input.equals("1"))
            return true;
        if (input.equals("2"))
            return false;
        throw new IllegalArgumentException("[ERROR] -> 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
