import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        boolean playAgain = true;
        System.out.println("🎮 Welcome to Rock, Paper, Scissors Game!");
        System.out.println("-----------------------------------------");
        while (playAgain) {
            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];
            System.out.print("\nEnter your choice (rock, paper, or scissors): ");
            String userChoice = sc.next().toLowerCase();
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("❌ Invalid choice! Please enter rock, paper, or scissors.");
                continue;
            }
            System.out.println("Computer chose: " + computerChoice);
            if (userChoice.equals(computerChoice)) {
                System.out.println("😐 It's a tie!");
            } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("🎉 You win!");
            } else {
                System.out.println("💻 Computer wins!");
            }

            // Ask to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String again = sc.next().toLowerCase();
            if (!again.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n👋 Thanks for playing Rock, Paper, Scissors!");
        sc.close();
    }
}
