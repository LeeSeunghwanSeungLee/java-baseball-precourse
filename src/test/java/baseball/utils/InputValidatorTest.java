package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    @DisplayName("숫자가 아닌 값을 입력시, 예외 발생")
    public void 숫자만입력() {
        String testInput = "asd";

        assertThatThrownBy(() -> InputValidator.validateInputType(testInput))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("빈 값을 입력시, 예외 발생")
    public void 빈값입력() {
        String testInput = "";

        assertThatThrownBy(() -> InputValidator.validateIsEmpty(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2개의 인풋 값을 입력시, 예외 발생")
    public void 두개입력() {
        String testInput = "12";

        assertThatThrownBy(() -> InputValidator.validateSize(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("4개의 인풋 값을 입력시, 예외 발생")
    public void 네개입력() {
        String testInput = "1352";

        assertThatThrownBy(() -> InputValidator.validateSize(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동일한 숫자값을 입력시, 예외 발")
    public void 동일숫자입력() {
        String testInput = "122";

        assertThatThrownBy(() -> InputValidator.validateEqualNumber(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 입력시, 예외 발")
    public void 범위밖숫자입력() {
        String testInput = "102";

        assertThatThrownBy(() -> InputValidator.validateNumberRange(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}