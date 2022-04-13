package baseball.model;

public enum BallScore {
    Strike(2), Ball(1), Nothing(0);

    private final int value;

    BallScore(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isStrike() {
        return this == Strike;
    }

    public boolean isBall() {
        return this == Ball;
    }
}
