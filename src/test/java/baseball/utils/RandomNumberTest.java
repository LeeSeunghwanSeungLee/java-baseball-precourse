package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class RandomNumberTest {
    @RepeatedTest(20)
    @DisplayName("3 번의 랜덤값을 1 ~ 9 에서 진행하는 지 20번 반복 확인")
    void 랜덤넘버생성테스트() {
        List<Integer>  randomNumberList = RandomNumber.make();
        Set<Integer> numberVariationCheck = new HashSet<>();

        for (Integer num : randomNumberList)
            numberVariationCheck.add(num);

        assertThat(randomNumberList.size()).isEqualTo(3);
        assertThat(numberVariationCheck.size()).isEqualTo(3);
    }
}