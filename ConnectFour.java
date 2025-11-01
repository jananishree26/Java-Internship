import java.util.Scanner;

public class ConnectFour {
    static final int ROWS = 6;
    static final int COLS = 7;
    static char[][] board = new char[ROWS][COLS];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;
        char currentPlayer = 'R'; // R = Red, Y = Yellow

        initializeBoard();
        System.out.println("🎮 Welcome to Connect Four!");
        printBoard();

        while (!gameOver) {
            System.out.println("Player " + currentPlayer + ", choose a column (1–7): ");
            int col = sc.nextInt() - 1;

            if (col < 0 || col >= COLS) {
                System.out.println("❌ Invalid column! Try again.");
                continue;
            }

            // Drop the piece in the selected column
            if (!dropPiece(col, currentPlayer)) {
                System.out.println("⚠️ Column full! Try another one.");
                continue;
            }

            printBoard();

            // Check for win
            if (checkWin(currentPlayer)) {
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (isBoardFull()) {
                System.out.println("😐 It's a tie!");
                gameOver = true;
            } else {
                // Switch players
                currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
            }
        }

        System.out.println("👋 Thanks for playing Connect Four!");
        sc.close();
    }

    // Initialize board
    public static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '.';
            }
        }
    }

    // Print board
    public static void printBoard() {
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
        System.out.println();
    }

    // Drop piece in column
    public static boolean dropPiece(int col, char player) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == '.') {
                board[i][col] = player;
                return true;
            }
        }
        return false;
    }

    // Check for win (horizontal, vertical, diagonal)
    public static boolean checkWin(char player) {
        // Horizontal
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && 
                    board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }
            }
        }

        // Vertical
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == player && board[i + 1][j] == player &&
                    board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }
            }
        }

        // Diagonal (down-right)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player &&
                    board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }

        // Diagonal (down-left)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 3; j < COLS; j++) {
                if (board[i][j] == player && board[i + 1][j - 1] == player &&
                    board[i + 2][j - 2] == player && board[i + 3][j - 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    // Check if board is full
    public static boolean isBoardFull() {
        for (int j = 0; j < COLS; j++) {
            if (board[0][j] == '.') {
                return false;
            }
        }
        return true;
    }
}
