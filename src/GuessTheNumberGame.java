import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private int targetNumber;
    private int turno;
    private boolean adivino;

    public GuessTheNumberGame() {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;
        System.out.println(" Number to guess " + this.targetNumber + "\n");
    }

    public void checkGuess(Player player) {
        int guess = player.makeGuess();
        System.out.println("\n" + " --- Round: " + player.getName() + " ---");
        System.out.println( player.getName() + ", enter your guess: " + guess);
        if (guess == targetNumber) {
            System.out.println("¡Congratulations!!!, " + player.getName() + " you guessed the number.");
            System.out.print("Attempts: ");
            printArray(player.getGuesses());

            adivino = true;
        } else {
            System.out.println("Keep on trying, " + player.getName() + "!!!" + "\n");
        }
    }
    private void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public void iniciarJuego() {
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Welcome to the Guess The NUMBER Game!!! ---" );
        System.out.print(" Enter your name: ");
        String playerName = scanner.next();
        humanPlayer.setName(playerName);

        computerPlayer.setName("Computer player");


        while (!adivino) {
            if (turno == 1) {
                checkGuess(humanPlayer);
                turno = 0;
            }else{
                checkGuess(computerPlayer);
                turno = 1;
            }
        }
    }
}