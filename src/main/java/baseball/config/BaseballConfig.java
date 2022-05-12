package baseball.config;

public enum BaseballConfig {
    Regame("1"),
    EndGame("2"),
    StartRange("1"),
    EndRange("9"),
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
