package baseball.model;

public class Baseball {
    private int position;
    private int no;

    public Baseball(int position, int no) {
        this.position = position;
        this.no = no;
    }

    public boolean isValid() {
        return no <= 9 && no >0;
    }

    public int getPosition() {
        return this.position;
    }

    public int getNumber() {
        return this.no;
    }

    public BallScore compare(Baseball ball) {
        if (this.no == ball.getNumber() && this.position == ball.getPosition())
            return BallScore.Strike;
        else if (this.no == ball.getNumber() && this.position != ball.getPosition())
            return BallScore.Ball;

        return BallScore.Nothing;
    }
}
