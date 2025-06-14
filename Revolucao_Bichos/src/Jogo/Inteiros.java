package Jogo;

public class Inteiros extends Number{
    private int[]dois = new int[2];

    public Inteiros(int ... args){
        int h=0;
        for(int i : args){
            dois[h] = i;
            h++;
        }
    }

    public int[] intsValue(){
        return dois;
    }
    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
