import java.util.Arrays;
import java.util.Random;
public class ComputerPlayer extends Player {
    public ComputerPlayer() {
        // Inicializa el array de conjeturas en el constructor
      //setGuesses(new int[0]);
    }

    @Override
    public int makeGuess() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        int[] currentGuesses = getGuesses();

        // Crear un nuevo arreglo con un tamaño incrementado en 1 y copiar elementos anteriores
        int[] newGuesses = Arrays.copyOf(currentGuesses, currentGuesses.length + 1);

        // Agregar el nuevo valor al final del nuevo arreglo
        newGuesses[newGuesses.length - 1] = numeroAleatorio;

        // Llamada al método setGuesses para establecer el nuevo arreglo
        setGuesses(newGuesses);
        return numeroAleatorio;
    }
}