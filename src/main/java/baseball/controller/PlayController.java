package baseball.controller;

import baseball.model.PlayResult;
import baseball.repository.PlayInning;
import baseball.utils.InputConsole;
import baseball.utils.InputValidator;
import baseball.utils.RandomNumber;
import baseball.view.View;

import java.util.List;

public class PlayController {
    private PlayInning computerBalls;
    private List<Integer> userBalls;

    public void start() {
        // 랜덤 결과를 생성한다 -> utils/RandomNumber
        computerBalls = new PlayInning(RandomNumber.make());

        play();
    }

    private void play() {
        try {
            View.EnterNumber.print();
            String consoleString = InputConsole.getStringFromConsole();

            InputValidator.validateInputType(consoleString);
            InputValidator.validateIsEmpty(consoleString);
            InputValidator.validateSize(consoleString);
            InputValidator.validateNumberRange(consoleString);
            InputValidator.validateEqualNumber(consoleString);

            userBalls = InputValidator.changeStringToNumberList(consoleString);

            PlayResult pr = this.computerBalls.play(userBalls);
            View.playResult(pr.toString());
            isWin(pr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            play();
        }
    }

    private void isWin(PlayResult pr) {
        if (pr.isGameEnd()) {
            View.GameEnd.print();
            View.RestartGameOrQuit.print();
            restartOrQuit();
            return;
        }
        play();
    }

    private void restartOrQuit() {
        try {
            isGameEnd();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            restartOrQuit();
        }
    }

    private void isGameEnd() {
        String userType = InputConsole.getStringFromConsole();
        if (userType.equals("1"))
            start();
        else if (userType.equals("2"))
            System.exit(0);
        throw new IllegalArgumentException("[ERROR] -> 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
