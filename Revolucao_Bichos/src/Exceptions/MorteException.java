package Exceptions;

public class MorteException extends Exception {
    public MorteException() {}

    @Override
    public String toString() {
        return "Animal foi morto";
    }
}
