package baseball;

import baseball.controller.FrontController;
import baseball.controller.PlayController;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        FrontController fc = FrontController.getInstance();
        fc.service();
    }
}
