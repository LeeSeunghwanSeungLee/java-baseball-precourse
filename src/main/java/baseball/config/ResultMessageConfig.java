package baseball.config;

public enum ResultMessageConfig {
    Ball("볼"),
    Strike("스트라이크"),
    Nothing("낫싱");

    private final String state;
    ResultMessageConfig(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
