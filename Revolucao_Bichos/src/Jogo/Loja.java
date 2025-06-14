package Jogo;//voltei

import Animais.*;
import java.util.*;

public class Loja {
    private Animal animais[] = new Animal[2];

    public Loja(){
        refresh();
        mostraLoja();

    }

    public void compraAnimal(Equipe equipe){
        int val = 0, val2 = 0;
        boolean semException=false;
        Scanner scanner = new Scanner(System.in);
        while(!semException || !(val < 0 && val > 1)) {
            System.out.println("Seleciona o animal: ");
            semException=true;
            try {
                val = scanner.nextInt();//ata
            } catch (InputMismatchException e) {
                System.out.println("Insira numero");
                semException = false;
            }
        }
        System.out.println("Insira a posicao da equipe");
        while(!semException || !(val2 < 0 && val2 > 1)) {
            System.out.println("Seleciona o animal: ");
            semException=true;
            try {
                val2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Insira numero");
                semException = false;
            }
        }
        equipe.insereParty(val2, animais[val]);

    }

    public void mostraLoja(){
        for(Animal animis: animais){
            System.out.println(animis.getClass() + ": \t" + animis.getPreco());
        }
    }

    public void refresh() {
        TiposAnimais[] tipo = TiposAnimais.values();
        for (int i = 0; i < 2; i++) {
            Random rand = new Random();
            if(rand.nextInt(100) <60) {
                do {
                    animais[i] = tipo[rand.nextInt(tipo.length)].criaAnimal();
                } while (animais[i].getRaridade() != 1);
            }
            else{
                animais[i] = tipo[rand.nextInt(tipo.length)].criaAnimal();
            }
        }
    }
}
