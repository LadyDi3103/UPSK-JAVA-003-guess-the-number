import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class HumanPlayer extends Player {
    public HumanPlayer()  {
    }

    @Override
    public int makeGuess() {
        //System.out.println("\n --- RoundMAKEGUESS: " + getName() + " ---");

        System.out.print(getName() + ", enter your guess: ");

        Scanner scanner = new Scanner(System.in);
        int numero = getValidatedNumber(scanner);

        int[] currentGuesses = getGuesses();
        // Crear un nuevo arreglo con un tamaño incrementado en 1 y copiar elementos anteriores
        int[] newGuesses = Arrays.copyOf(currentGuesses, currentGuesses.length + 1);

        // Agregar el nuevo valor al final del nuevo arreglo
        newGuesses[newGuesses.length - 1] = numero;

        // Llamada al método setGuesses para establecer el nuevo arreglo
        setGuesses(newGuesses);

        return numero;
    }
    private int getValidatedNumber(Scanner scanner) {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                //System.out.print("Pon un numero: ");
                number = scanner.nextInt();

                if (number < 1 || number > 100) {
                    System.out.println("Error: The number must be between 1 and 100.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Only numbers are allowed.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }

        return number;
    }

    //private boolean isHuman() {
        //return this instanceof HumanPlayer;
    //}
}