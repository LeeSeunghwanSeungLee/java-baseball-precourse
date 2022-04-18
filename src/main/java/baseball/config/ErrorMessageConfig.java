package baseball.config;

public enum ErrorMessageConfig {
    InputType("[ERROR] - 숫자만 입력바랍니다."),
    InputEmpty("[ERROR] - 빈 값을 입력했습니다."),
    InputSize("[ERROR] - 3개의 숫자를 입력하셔야 합니다."),
    InputNumberRange("[ERROR] - 입력 숫자의 범위는 1 ~ 9 사이어야 합니다."),
    InputSameNumber("[ERROR] - 동일한 숫자가 2번 이상 반복되었습니다.");

    private final String errorMsg;

    ErrorMessageConfig(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }
}
