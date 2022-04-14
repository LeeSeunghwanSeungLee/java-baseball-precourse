package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputConsole {
    public static String getStringFromConsole() {
        return Console.readLine();
    }

    public static List<Integer> changeString2List(String str) {
        String[] numbers = str.split("");

        List<Integer> res = new ArrayList<>();
        for (String num : numbers)
            res.add(Integer.parseInt(num));

        return res;
    }
}
