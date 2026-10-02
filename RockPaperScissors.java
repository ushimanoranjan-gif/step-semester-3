import java.util.Random;

public class RockPaperScissors {
    static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        boolean playerWins =
            (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        // Predefined player moves for a live demo (replace with Scanner input if desired)
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int n = playerMoves.length;
        String[] computerMoves = new String[n];
        String[] results = new String[n];
        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            computerMoves[i] = MOVES[rand.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            System.out.println("Round " + (i + 1) + " — Player: " + playerMoves[i]
                    + ", Computer: " + computerMoves[i] + " -> " + results[i]);
            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println("\n-------------------------------------------------");
        System.out.printf("%-7s | %-12s | %-13s | %s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-7d | %-12s | %-13s | %s%n", i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("-------------------------------------------------");
        double winPct = (wins * 100.0) / n;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPct);
    }
}
