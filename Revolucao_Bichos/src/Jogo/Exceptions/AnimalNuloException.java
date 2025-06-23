package Jogo.Exceptions;

public class AnimalNuloException extends Exception{
    @Override
    public String toString() {
        return "Animal não existe";
    }
}
