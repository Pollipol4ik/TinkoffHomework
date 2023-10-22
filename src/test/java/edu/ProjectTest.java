package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.project1.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ProjectTest {

    @Test
    @DisplayName("Тест проигрыша игрока")
    public void sessionGuessWhenUserIsOutOfMistakes() {
        Session session = new Session(new InPartOfTheDictionary(new String[] {"python"}));

        session.guess('f');
        session.guess('f');
        session.guess('f');
        session.guess('f');
        GuessResult actual = session.guess('f');

        assertThat(actual).isInstanceOf(Defeat.class);

    }

    @Test
    @DisplayName("Тест победы игрока ")
    public void sessionGuessShouldReturnWinGuessResult_whenNUserGuessedTheWord() {
        Session session = new Session(new InPartOfTheDictionary(new String[] {"class"}));

        session.guess('c');
        session.guess('l');
        session.guess('a');
        GuessResult actual = session.guess('s');

        assertThat(actual).isInstanceOf(Win.class);

    }
    @Test
    @DisplayName("Тест при букве, не находящейся в загаданном слове")
    public void sessionStateShouldChangingCorrectly_whenUserHasFailedGuess() {
        Session session = new Session(new InPartOfTheDictionary(new String[] {"java"}));
        GuessResult failedGuess = session.guess('m');
        Assertions.assertAll(
            () -> assertThat(failedGuess.attempt()).isEqualTo(1),
            () -> assertThat(failedGuess).isInstanceOf(FailedGuess.class),
            () -> assertThat(failedGuess.state()).containsExactly('*', '*', '*', '*')
        );
    }

    @Test
    @DisplayName("Тест при букве, находящейся в загаданном слове")
    public void sessionStateShouldChangingCorrectly_whenUserHasSuccessfulGuess() {
        Session session = new Session(new InPartOfTheDictionary(new String[] {"java"}));
        GuessResult successfulGuess = session.guess('j');
        Assertions.assertAll(
            () -> assertThat(successfulGuess.attempt()).isEqualTo(0),
            () -> assertThat(successfulGuess).isInstanceOf(SuccessfulGuess.class),
            () -> assertThat(successfulGuess.state()).containsExactly('j', '*', '*', '*')
        );
    }



    @Test
    @DisplayName("Ctrl+D тест")
    public void shouldReturnDefeat_whenUserGaveUp() {
        Session session = new Session(new InPartOfTheDictionary(new String[] {"java"}));
        GuessResult actual = session.guess((char) 0x04);
        assertThat(actual).isInstanceOf(Defeat.class);
    }


}
