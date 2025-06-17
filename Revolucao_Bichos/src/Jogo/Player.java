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

    public void criaArray(Equipe e1){
        Animal[] animasi = new Animal[3];//oq q voce falo
        TiposAnimais[] tipo = TiposAnimais.values();
        for(int i = 0; i<3; i++){
            Random rand = new Random();
            animasi[i] = tipo[rand.nextInt(tipo.length)].criaAnimal();
            e1.insereParty(i, animasi[i]);
        }
    }
}
