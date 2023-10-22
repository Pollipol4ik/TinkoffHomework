package edu.project1;

import org.jetbrains.annotations.NotNull;

public record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {

    @Override
    @NotNull
    public String message() {
        return "Missed, mistake " + attempt + " out of " + maxAttempts + ".";
    }
}
