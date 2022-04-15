package baseball.view;

public enum View {
    EnterNumber("숫자를 입력해주세요: "),
    GameEnd("3개의숫자를모두맞히셨습니다! 게임 종료\n"),
    RestartGameOrQuit("게임을새로시작하려면 1 , 종료하려면 2를입력하세요.\n");

    public static void playResult(String result){
        System.out.println(result);
    }

    private final String screenSubTitle;

    View(String screenSubTitle) {
        this.screenSubTitle = screenSubTitle;
    }

    public void print(){
        System.out.print(this.screenSubTitle);
    }

    public String getStringToprint() {
        return screenSubTitle;
    }

}