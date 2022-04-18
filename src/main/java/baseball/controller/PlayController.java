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

    public void startGame() {
        computerBalls = new PlayInning(RandomNumber.make());
        playResult = new PlayResult();
        playGame();
    }

    protected void playGame() {
        View.EnterNumber.print();
        String input = Console.readLine();
        List<Integer> userBalls = inputHandler.makeNumberList(input);
        playResult =  computerBalls.play(userBalls);
        View.showSubtitle(playResult.toString());
        if (checkEnd())
            commentWin();
    }

    public boolean checkEnd() {
        if (playResult.isGameEnd())
            return true;
        return false;
    }

    public void commentWin() {
        View.GameEnd.print();
        askRestart();
    }

    private void askRestart() {
        View.RestartGameOrQuit.print();
        String input = Console.readLine();
        if (inputHandler.isRegame(input))
            startGame();
    }


    public void start() {
        computerBalls = new PlayInning(RandomNumber.make());
        playResult = new PlayResult();
        while(!playResult.isGameEnd())
            play();
        win();
    }

    private void play() {
        View.EnterNumber.print();
        String input = Console.readLine();
        try {
            List<Integer> userBalls = inputHandler.makeNumberList(input);
            playResult =  computerBalls.play(userBalls);
            View.showSubtitle(playResult.toString());
        } catch (Exception e) {
            View.showSubtitle(e.getMessage());
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
            View.showSubtitle(e.getMessage());
            restartOrQuit();
        }
    }

    private void isGameEnd() {
        String input = Console.readLine();
        if (inputHandler.isRegame(input))
            start();
    }
}
