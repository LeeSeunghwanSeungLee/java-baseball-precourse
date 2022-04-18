package baseball.model;

public class Baseball {
    private int position;
    private int no;

    public Baseball(int position, int no) {
        this.position = position;
        this.no = no;
    }

    public int getPosition() {
        return this.position;
    }

    public int getNumber() {
        return this.no;
    }

    public BallScore compare(Baseball ball) {
        if (this.equals(ball))
            return BallScore.Strike;
        if (this.isBall(ball))
            return BallScore.Ball;

        return BallScore.Nothing;
    }

    private boolean isBall(Baseball ball) {
        return no == ball.getNumber() && position != ball.getPosition();
    }

    @Override
    public boolean equals(Object obj) {
        Baseball target = (Baseball) obj;
        return position == target.getPosition() && no == target.getNumber();
    }

    public boolean isValid() {
        return no <= 9 && no >0;
    }
}
