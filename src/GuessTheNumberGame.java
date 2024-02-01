import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private int targetNumber;
    private int turno;
    private boolean adivino;

    public GuessTheNumberGame() {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;
        System.out.println(" Number to guess: " + this.targetNumber + "\n");
    }

    public void checkGuess(Player player) {
        int guess;
        System.out.println("\n --- Round: " + player.getName() + " ---");

        if (player instanceof HumanPlayer) {
            guess = player.makeGuess();
        } else {
            guess = player.makeGuess();
           System.out.println(player.getName() + ", enter your guess: " + guess);

        }



        //System.out.println( player.getName() + ", enter your guessYYYY: " + guess);

        player.incrementAttempts(); // Incrementa el contador de intentos

        if (guess == targetNumber) {
            System.out.println("¡Congratulations!!!, " + player.getName() + " you guessed the number!!!\n");
            System.out.print("Attempts: ");
            printArray(player.getGuesses());
            System.out.println("Total Attempts: [" + player.getNumberOfAttempts() + "]");

            adivino = true;
        } else {
            printDistanceMessage(guess);
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
    private void printDistanceMessage(int guess) {
        int difference = Math.abs(targetNumber - guess);

        if (difference <= 3) {
            System.out.println("That was very close, keep on trying!!!");
        } else {
            System.out.println("Keep on trying, you are far from the number!!!");
        }
        System.out.println();
    }
    public void iniciarJuego() {
        HumanPlayer humanPlayer = new HumanPlayer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Welcome to the Guess The NUMBER Game!!! ---" );
        System.out.print(" Enter your name: ");
        String name = scanner.next();
        humanPlayer.setName(name);
        ComputerPlayer computerPlayer = new ComputerPlayer();
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