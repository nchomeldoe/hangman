package org.example;

import java.util.ArrayList;

public class ResultsDisplayer {
    private ArrayList<String> guesses;

    public ResultsDisplayer() {
        this.guesses = new ArrayList<>();
    }

    public ArrayList<String> getGuesses() {
        return guesses;
    }

    public void setGuesses(String guess) {
        this.guesses.add(guess);
    }

    public static String displayResult(String word, ArrayList<String> guesses) {
        String[] characters = word.split("");
        ArrayList<String> resultArray = new ArrayList<>();
        for (int i = 0; i < characters.length; i++) {
            resultArray.add("_");
        }
        for (int i = 0; i < characters.length; i++) {
            for (String guess : guesses) {
                if (characters[i].equals(guess)) {
                    resultArray.set(i, characters[i]);
                }
            }

        }
        return String.join(" ", resultArray);
    }

}
