package baseball.utils;

import baseball.config.BaseballConfig;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
    private RandomNumber() {}

    public static List<Integer> make() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < BaseballConfig.BaseballSize.getConfigInt(); i++)
            RandomNumber.makeRandomNumber(randomNumbers);

        return randomNumbers;
    }

    private static void makeRandomNumber(List<Integer> randomNumbers) {
        int start = BaseballConfig.StartRange.getConfigInt();
        int end = BaseballConfig.EndRange.getConfigInt();

        int randomNum = Randoms.pickNumberInRange(start, end);
        if (RandomNumber.checkExistNumber(randomNumbers, randomNum)) {
            RandomNumber.makeRandomNumber(randomNumbers);
            return;
        }
        randomNumbers.add(randomNum);
    }

    private static boolean checkExistNumber(List<Integer> randomNumbers, Integer number) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (number.equals(randomNumbers.get(i)))
                return true;
        }
        return false;
    }
}
