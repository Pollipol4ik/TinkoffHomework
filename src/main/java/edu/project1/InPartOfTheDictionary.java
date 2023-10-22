package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class InPartOfTheDictionary implements Dictionary {
    private final String[] words;

    public InPartOfTheDictionary(String[] words) {
        this.words = words;
    }

    @Override
    @NotNull
    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

}
