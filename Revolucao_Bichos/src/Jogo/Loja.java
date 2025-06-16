package Jogo;//voltei

import Animais.*;
import Itens.*;

import java.util.*;

public class Loja {
    private Animal animais[] = new Animal[2];
    private Item equipamento[] = new Item[3];

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
    public void compraEquipamento(Equipe equipe){
        int val = 0, val2 = 0, dinheiro;
        boolean semException=false;
        Scanner scanner = new Scanner(System.in);
        while(!semException || !(val < 0 && val > 3)) {
            System.out.println("Seleciona o item: ");
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
        if(equipamento[val].getClass() == Consumivel.class){
            equipe.insereConsumivel(val2, (Consumivel) equipamento[val]);
        }else{
            equipe.insereEquipamento(val2, equipamento[val]);
        }
    }

    public void mostraLoja(){
        for(Animal animis: animais){
            System.out.println(animis.getClass() + "\t: " + animis.getPreco());
        }
        for (Item item : equipamento){
            System.out.println(item.getClass() + "\t: " + item.getPreco());
        }
    }

    public void refresh() {
        TiposAnimais[] tipo1 = TiposAnimais.values();
        TipoItem[] tipo2 = TipoItem.values();
        for (int i = 0; i < 2; i++) {
            Random rand = new Random();
            if(rand.nextInt(100) <60) {
                do {
                    animais[i] = tipo1[rand.nextInt(tipo1.length)].criaAnimal();
                } while (animais[i].getRaridade() != 1);
            }
            else{
                animais[i] = tipo1[rand.nextInt(tipo1.length)].criaAnimal();
            }

        }
        for(int i = 0; i<3; i++){
            Random rand = new Random();
            equipamento[i] = tipo2[rand.nextInt(tipo2.length)].criaItem();
        }
    }
}
