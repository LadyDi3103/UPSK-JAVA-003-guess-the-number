
abstract  public class Player {
    private String name;
    private int[] guesses= new int[0];
    private int numberOfAttempts = 0;
    public Player() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getGuesses() {
        return guesses;
    }

    public void setGuesses(int[] guesses) {
        this.guesses = guesses;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
    public void incrementAttempts() {
        numberOfAttempts++;
    }
    abstract public int makeGuess();

    }

