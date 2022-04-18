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
        while(randomNumbers.size() < BaseballConfig.BaseballSize.getConfigInt()) {
            RandomNumber.makeRandomNumber(randomNumbers);
        }
        return randomNumbers;
    }

    private static void makeRandomNumber(List<Integer> randomNumbers) {
        int start = BaseballConfig.StartRange.getConfigInt();
        int end = BaseballConfig.EndRange.getConfigInt();

        int newRandomNumber = Randoms.pickNumberInRange(start, end);
        if (checkExistNumber(newRandomNumber, randomNumbers))
            randomNumbers.add(newRandomNumber);
    }

    private static boolean checkExistNumber( Integer newNumber, List<Integer> randomNumbers) {
        int checkNum = 0;
        for (Integer oldNum : randomNumbers)
            checkNum += (oldNum == newNumber) ? 1 : 0;

        return checkNum == 0;
    }
}
