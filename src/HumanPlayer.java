import java.util.Scanner;
import java.util.Arrays;

public class HumanPlayer extends Player {
    public HumanPlayer()  {
    }

    @Override
    public int makeGuess() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Round: Diana --- ");

        int numero = scanner.nextInt();
        int[] currentGuesses = getGuesses();

        // Crear un nuevo arreglo con un tamaño incrementado en 1 y copiar elementos anteriores
        int[] newGuesses = Arrays.copyOf(currentGuesses, currentGuesses.length + 1);

        // Agregar el nuevo valor al final del nuevo arreglo
        newGuesses[newGuesses.length - 1] = numero;

        // Llamada al método setGuesses para establecer el nuevo arreglo
        setGuesses(newGuesses);
        return numero;
    }
}