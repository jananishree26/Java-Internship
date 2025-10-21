import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberLimited {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1; // Random number 1–100
        int attempts = 7; // Limit of attempts
        boolean guessedCorrect = false;

        System.out.println("🎮 Welcome to Guess the Number Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("You have " + attempts + " attempts to guess it!");

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            attempts--;

            if (userGuess == numberToGuess) {
                System.out.println("🎉 Congratulations! You guessed it correctly.");
                guessedCorrect = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            if (attempts > 0) {
                System.out.println("You have " + attempts + " attempts left.\n");
            }
        }

        if (!guessedCorrect) {
            System.out.println("❌ Sorry, you’ve run out of attempts.");
            System.out.println("The number was: " + numberToGuess);
        }

        sc.close();
    }
}