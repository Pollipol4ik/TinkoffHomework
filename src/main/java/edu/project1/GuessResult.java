package edu.project1;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult permits Defeat, FailedGuess, SuccessfulGuess, Win {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

}
