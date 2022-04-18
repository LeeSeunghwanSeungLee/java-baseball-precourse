package baseball.config;

public enum BaseballConfig {
    Endgame("1"),
    Regame("2"),
    BaseballSize("3");

    private final String config;

    BaseballConfig(String config) {
        this.config = config;
    }

    public String getConfig() {
        return this.config;
    }

    public Integer getConfigInt() {
        return Integer.parseInt(this.config);
    }
}
