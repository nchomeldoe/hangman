package org.example;

public class HangmanGame {

    private int guessLimit;

    public void startGame() {
        System.out.println("Hangman: Guess one character at a time to reveal the word.");

    }

    public int getGuessLimit() {
        return guessLimit;
    }

    public void setGuessLimit(int wordLength, Level level) {
        switch(level) {
            case BEGINNER: this.guessLimit = wordLength + 8;
            break;
            case INTERMEDIATE: this.guessLimit = wordLength + 5;
                break;
            case ADVANCED: this.guessLimit = wordLength + 3;
                break;

        }

    }

    public void gameLost(String word) {
        System.out.println("No more guesses left. Game over!");
        System.out.println("The word was: " + word);
    }

    public void gameWon() {
        System.out.println("Congratulations! You won.");
    }



    public void playGame() {
        String newWord = WordSelector.selectWord();
        startGame();
        setGuessLimit(newWord.length(), InputReader.setDesiredLevel());
        System.out.println("You have " + getGuessLimit() + " guesses.");
        ResultsDisplayer newResultsDisplayer = new ResultsDisplayer();
        newResultsDisplayer.setGuesses("");
        String displayedResult = ResultsDisplayer.displayResult(newWord, newResultsDisplayer.getGuesses());
        while(displayedResult.contains("_")){
            if(newResultsDisplayer.getGuesses().size() == getGuessLimit() + 1) {
                gameLost(newWord);
                return;
            }
            System.out.println(displayedResult);
            String guessedLetter = InputReader.readUserInput();
            if(newResultsDisplayer.getGuesses().contains(guessedLetter)) {
                System.out.println("You have already guessed " + guessedLetter + ". Please try another letter.");
            } else {
                newResultsDisplayer.setGuesses(guessedLetter);
                System.out.println("Guesses remaining: "+ (getGuessLimit() - (newResultsDisplayer.getGuesses().size() - 1)));
                displayedResult = ResultsDisplayer.displayResult(newWord, newResultsDisplayer.getGuesses());
            }
        }
        System.out.println(displayedResult);
        gameWon();

    }

}
