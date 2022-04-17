package baseball.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeTransformer {
    private TypeTransformer() {}

    public static List<Integer> changeString2List(String rawInput) {
        List<Integer> res = new ArrayList<>();
        String[] numbers = rawInput.split("");

        for (String num : numbers)
            res.add(Integer.parseInt(num));

        return res;
    }
}
