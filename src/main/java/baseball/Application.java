package baseball;

import baseball.controller.PlayController;

public class Application {
    public static void main(String[] args) {
        PlayController controller = new PlayController();
        controller.start();
    }
}
