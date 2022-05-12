package baseball.utils;

import baseball.config.ErrorMessageConfig;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    private InputValidator() {}

    public static void validateInputType(String rawInput) {
        try {
            int number = Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConfig.InputType.getErrorMessage());
        }
    }

    public static void validateIsEmpty(String rawInput) {
        if (rawInput == null || rawInput.length() == 0) {
            throw new IllegalArgumentException(ErrorMessageConfig.InputEmpty.getErrorMessage());
        }
    }

    public static void validateSize(String rawInput) {
        if (rawInput.length() != 3)
            throw new IllegalArgumentException(ErrorMessageConfig.InputSize.getErrorMessage());
    }

    public static void validateNumberRange(String rawInput) {
        List<Integer> userTrialNumber = TypeTransformer.changeString2List(rawInput);
        InputValidator.validateNumberRange(userTrialNumber);
    }

    public static void validateNumberRange(List<Integer> userTrialNumber) {
        for (Integer num : userTrialNumber) {
            InputValidator.isRange(num);
        }
    }

    private static void isRange(Integer num) {
        if (num > 9 || num <= 0)
            throw new IllegalArgumentException(ErrorMessageConfig.InputNumberRange.getErrorMessage());
    }

    public static void validateEqualNumber(String rawInput) {
        List<Integer> userTrialNumber = TypeTransformer.changeString2List(rawInput);
        InputValidator.validateEqualNumber(userTrialNumber);
    }

    public static void validateEqualNumber(List<Integer> userTrialNumber) {
        String errorComment = ErrorMessageConfig.InputSameNumber.getErrorMessage();

        if (userTrialNumber.get(0) == userTrialNumber.get(1))
            throw new IllegalArgumentException(errorComment);

        if (userTrialNumber.get(0) == userTrialNumber.get(2))
            throw new IllegalArgumentException(errorComment);

        if (userTrialNumber.get(1) == userTrialNumber.get(2))
            throw new IllegalArgumentException(errorComment);
    }
}
