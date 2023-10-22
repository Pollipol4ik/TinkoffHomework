package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private static final char CTRL_D = 0x04;
    private static final Logger LOGGER = LogManager.getLogger();
    private Session session;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleHangman(Dictionary dict) {
        session = new Session(dict);
    }

    private void printState(GuessResult guess) {
        LOGGER.info(guess.message());
        LOGGER.info("The word: " + new String(guess.state()));
    }

    public void run() {
        LOGGER.info("Welcome to the Hangman game!");
        while (session.getGameStatus() != GameStatus.COMPLETED) {
            char usersLetter = getUserInput();
            printState(tryGuess(usersLetter));
        }
    }

    private GuessResult tryGuess(char input) {
        return session.guess(input);
    }

    private char getUserInput() {
        LOGGER.info("Guess a letter: ");
        while (true) {
            if (!scanner.hasNextLine()) {
                return CTRL_D;
            }
            String input = scanner.nextLine();
            if (!input.matches("[a-zA-Z-]") || input.length() != 1) {
                LOGGER.info("Please, try again with correct input");
            } else {
                return Character.toLowerCase(input.charAt(0));
            }
        }
    }
}


