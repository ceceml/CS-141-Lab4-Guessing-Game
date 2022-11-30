import java.util.*;
import java.lang.Math;

public class GuessingGame {

    public static final int MAX = 100;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int max = MAX;
        int min = 1;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        int gameCount = 1;

        gameIntro();
        System.out.print("Your Guess? ");
        System.out.println();
        int tempGuess = gamePlay(rand, console);
        int round = 1;
        String playAgain = console.next().toLowerCase();
        while (!playAgain.startsWith("n")) {
            rand = (int)(Math.random() * range) + min;
            System.out.println();
            System.out.println("I'm thinking of a number between 1 and 100...\n");
            tempGuess = gamePlay(rand, console) + tempGuess;
            rand = (int)(Math.random() * range) + min;
            gameCount++;
            playAgain = console.next().toLowerCase();
            round++;
        }
        double playRatio = tempGuess/gameCount;
        gameSummary(gameCount, tempGuess, playRatio, round);
    }

    public static void gameSummary(int gameCount, int tempGuess, double playRatio, int round){
        System.out.println("Overall results: ");
        System.out.println(" \ttotal games   =" + gameCount);
        System.out.println(" \ttotal guesses =" + tempGuess);
        System.out.println(" \tguesses/game  =" + playRatio);
    }

    public static int gamePlay(int rand, Scanner console) {
        int guessCount = 1;
        int gameCount = 1;
        int userNumber = console.nextInt();
        while(userNumber != rand){
            if(userNumber < rand){
                System.out.println("It's Higher\n");
                System.out.print("Your Guess? ");
                userNumber = console.nextInt();
                System.out.println();
                guessCount++;
            }
            else {
                System.out.println("It's Lower\n");
                System.out.print("Your Guess? ");
                userNumber = console.nextInt();
                System.out.println();
                guessCount++;
            }
        }
        System.out.println("You got it right in " + guessCount + " guesses\n");
        System.out.print("Would you like to play again?");
        gameCount++;
        return guessCount;
    }

    public static void gameIntro() {
        System.out.println("This program allows you to play a guessing game");
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess");
        System.out.println("\n");
        System.out.println("I'm thinking of a number between 1 and 100... ");
    }
}
