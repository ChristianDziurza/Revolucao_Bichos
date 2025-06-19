package Jogo;

import Animais.Animal;
import Animais.TiposAnimais;

import java.util.Random;

public class Player {
    private int dinheiro;


    public int ganhaDinheiro(int x){
        this.dinheiro = dinheiro+x;
        return dinheiro;
    }

    public int gastaDinheiro(int x){
        this.dinheiro = dinheiro-x;
        return dinheiro;
    }
    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    
}
