package baseball.model;

public enum BallScore {
    Strike(0), Ball(1), Nothing(2);

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
