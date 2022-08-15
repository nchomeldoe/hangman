package org.example;

import java.util.ArrayList;
import java.util.Random;

public class WordSelector {

    private static final Random RANDOM = new Random();
    private static ArrayList<String> words = new ArrayList<>();

    static {
        words.add("promotion");
        words.add("housewife");
        words.add("reliance");
        words.add("represent");
        words.add("fascinate");
        words.add("conservation");
        words.add("greeting");
        words.add("fluctuation");
        words.add("eavesdrop");
        words.add("gregarious");
        words.add("mainstream");
        words.add("broccoli");
        words.add("difference");
        words.add("intermediate");
        words.add("standard");
        words.add("paralyzed");
        words.add("perforate");
        words.add("possibility");
        words.add("transfer");
        words.add("apparatus");
    }

    public static String selectWord() {
        int randomIndex =  RANDOM.nextInt(words.size());
        return words.get(randomIndex);
    }


}
