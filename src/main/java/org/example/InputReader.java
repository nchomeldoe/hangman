package org.example;

import java.util.Scanner;

public class InputReader {
    public static Scanner scanner = new Scanner(System.in);

    public static String readUserInput() {
        String result = "";
        boolean resultIsValid = false;
        while(!resultIsValid) {
            result = scanner.nextLine();
            if(result.length() > 1 || !result.matches("^[a-zA-Z]*$")) {
                System.out.println("Please enter one single letter only.");
            }
            else {
                resultIsValid = true;
            };
        }
        return result.toLowerCase();
    }

    public static Level setDesiredLevel() {
        System.out.println("Select a level to play at: type 1 for beginner, 2 for intermediate or 3 for advanced");
        String result = "";
        boolean resultIsValid = false;
        while(!resultIsValid) {
            result = scanner.nextLine();
            if(result.length() > 1 || !result.matches("^[1-3]*$")) {
                System.out.println("Please enter 1, 2 or 3 only. 1 for beginner, 2 for intermediate, or 3 for advanced.");
            }
            else {
                resultIsValid = true;
            };
        }
        switch(result) {
            case "3": return Level.ADVANCED;
            case "2": return Level.INTERMEDIATE;
            default: return Level.BEGINNER;
        }
    }

}
