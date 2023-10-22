package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Session {
    private static final int MAX_MISTAKES = 5;
    private static final int MIN_WORD_LENGTH = 4;
    private static final char CTRL_D = 0x04;

    private final String answer;
    private final char[] userAnswer;
    private int attempts;

    private GameStatus status;
    private int counter;

    public Session(Dictionary dict) {
        this.answer = dict.getRandomWord();
        this.status = GameStatus.RUNNING;
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
        if (this.answer.length() < MIN_WORD_LENGTH) {
            throw new IllegalStateException("Word length should be at least " + MIN_WORD_LENGTH);
        }
    }

    @NotNull public GuessResult guess(char guess) {
        if (answer.indexOf(guess) != -1 && !isEndOfInput(guess)) {
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == guess) {
                    userAnswer[i] = answer.charAt(i);
                    counter++;
                }
            }
            if (counter == answer.length()) {
                status = GameStatus.COMPLETED;
                return new Win(userAnswer, attempts, MAX_MISTAKES);
            }
            return new SuccessfulGuess(userAnswer, attempts, MAX_MISTAKES);
        }
        attempts++;
        if (isEndOfInput(guess) || attempts == MAX_MISTAKES) {
            return giveUp();
        }
        return new FailedGuess(userAnswer, attempts, MAX_MISTAKES);
    }

    private GuessResult giveUp() {
        status = GameStatus.COMPLETED;
        return new Defeat(answer.toCharArray(), attempts, MAX_MISTAKES);
    }

    public GameStatus getGameStatus() {
        return status;
    }

    private boolean isEndOfInput(char input) {
        return input == CTRL_D;
    }
}
