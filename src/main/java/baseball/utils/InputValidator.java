package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public static void validateInputType(String rawInput) {
        try {
            int number = Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] - 숫자만 입력바랍니다.");
        }
    }

    public static void validateIsEmpty(String rawInput) {
        if (rawInput == null || rawInput.length() == 0) {
            throw new IllegalArgumentException("[ERROR] - 빈 값을 입력했습니다.");
        }
    }

    public static void validateSize(String rawInput) {
        if (rawInput.length() != 3)
            throw new IllegalArgumentException("[ERROR] - 3개의 숫자를 입력하셔야 합니다.");
    }

    public static void validateNumberRange(String rawInput) {
        List<Integer> userTrialNumber = InputValidator.changeStringToNumberList(rawInput);
        InputValidator.validateNumberRange(userTrialNumber);
    }

    public static void validateNumberRange(List<Integer> userTrialNumber) {
        for (Integer num : userTrialNumber) {
            InputValidator.isRange(num);
        }
    }

    private static void isRange(Integer num) {
        if (num > 9 || num <= 0)
            throw new IllegalArgumentException("[ERROR] - 입력 숫자의 범위는 1 ~ 9 사이어야 합니다.");
    }

    public static void validateEqualNumber(String rawInput) {
        List<Integer> userTrialNumber = InputValidator.changeStringToNumberList(rawInput);
        InputValidator.validateEqualNumber(userTrialNumber);
    }

    public static void validateEqualNumber(List<Integer> userTrialNumber) {
        String errorComment = "[ERROR] - 동일한 숫자가 2번 이상 반복되었습니다.";

        if (userTrialNumber.get(0) == userTrialNumber.get(1))
            throw new IllegalArgumentException(errorComment);

        if (userTrialNumber.get(0) == userTrialNumber.get(1))
            throw new IllegalArgumentException(errorComment);

        if (userTrialNumber.get(1) == userTrialNumber.get(2))
            throw new IllegalArgumentException(errorComment);
    }

    private static List<Integer> changeStringToNumberList(String rawInput) {
        List<Integer> res = new ArrayList<>();
        String[] numbers = rawInput.split("");

        for (String num : numbers)
            res.add(Integer.parseInt(num));

        return res;
    }
}
