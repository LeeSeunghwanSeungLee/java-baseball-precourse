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
}
