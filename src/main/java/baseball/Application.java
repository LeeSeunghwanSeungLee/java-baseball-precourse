package baseball;

import baseball.controller.PlayController;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        PlayController controller = new PlayController();
        try {
            controller.startGame();
        } catch (Exception e) {
            View.showSubtitle(e.getMessage());
            controller.startGame();
        }
    }

}
