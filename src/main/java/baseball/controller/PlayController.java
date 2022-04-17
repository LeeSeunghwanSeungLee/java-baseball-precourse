package baseball.controller;

import baseball.model.BallScore;
import baseball.model.PlayResult;
import baseball.repository.PlayInning;
import baseball.utils.InputHandler;
import baseball.utils.InputValidator;
import baseball.utils.RandomNumber;
import baseball.utils.TypeTransformer;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class PlayController {
    private PlayInning computerBalls;
    private InputHandler inputHandler;
    private PlayResult playResult;

    public PlayController() {
        this.inputHandler = new InputHandler();
        this.playResult = new PlayResult();
    }

    public void start() {
        computerBalls = new PlayInning(RandomNumber.make());
        playResult = new PlayResult();
        while(!playResult.isGameEnd())
            play();
        win();
    }

    private void play() {
        try {
            View.EnterNumber.print();
            String input = Console.readLine();
            List<Integer> userBalls = inputHandler.makeNumberList(input);
            playResult =  computerBalls.play(userBalls);
            View.playResult(playResult.toString());
        } catch (Exception e) {
            View.playResult(e.getMessage());
            play();
        }
    }

    private void win() {
        View.GameEnd.print();
        restartOrQuit();
    }

    private void restartOrQuit() {
        try {
            View.RestartGameOrQuit.print();
            isGameEnd();
        } catch (Exception e) {
            View.playResult(e.getMessage());
            restartOrQuit();
        }
    }

    private void isGameEnd() {
        String input = Console.readLine();
        if (inputHandler.isRegame(input))
            start();
    }
}
