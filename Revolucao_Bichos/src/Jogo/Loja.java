package Jogo;//voltei

import Animais.*;
import Itens.*;

import java.util.*;

public class Loja {
    private Animal animais[] = new Animal[2];
    private Item equipamento[] = new Item[3];
    Player player;

    public Loja(Player player){
        refresh();
        this.player = player;
    }

    public void compraAnimal(Equipe equipe, Player p1){
        int val = 0, val2 = 0;
        boolean semException=false;
        Scanner scanner = new Scanner(System.in);
        while(!semException || (val < 0 && val > 1)) {
            System.out.println("Seleciona o animal: ");
            semException=true;
            try {
                val = scanner.nextInt();//mas eu faço
            } catch (InputMismatchException e) {
                System.out.println("Insira numero");
                val = -1;
                semException = false;
            }

        }
        try {
            if(p1.getDinheiro() < animais[val].getPreco()){
                System.out.println("Nao tem dinhero");
            }else {
                semException = false;
                player.gastaDinheiro(animais[val].getPreco());
                while (!semException || (val2 < 0 && val2 > 2)) {
                    System.out.println("Seleciona o espaço da equipe: ");
                    semException = true;
                    try {
                        val2 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Insira numero");
                        val2 = -1;
                        semException = false;
                    }
                }
                Animal anima = equipe.getAnimais()[2];
                equipe.insereParty(val2, animais[val]);
                if(anima == null){
                    animais[val] = null;
                }
            }
        }catch (NullPointerException e){
            System.out.println("Este animal nao esta disponivel");
            semException = false;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Este animal nao esta disponivel");
            semException = false;
        }

    }
    public void compraEquipamento(Equipe equipe, Player p1){
        int val = 0, val2 = 0, dinheiro;
        boolean semException=false;
        Scanner scanner = new Scanner(System.in);
        while(!semException || (val < 0 && val > 2)) {
            System.out.println("Seleciona o item: ");
            semException=true;
            try {
                val = scanner.nextInt();//ata
            } catch (InputMismatchException e) {
                System.out.println("Insira numero");
                val = -1;
                semException = false;
            }
        }
        try{
            if(p1.getDinheiro() < equipamento[val].getPreco()){
                System.out.println("Sem dinheiro");
            }else {
                semException = false;
                player.gastaDinheiro(equipamento[val].getPreco());
                while (!semException || (val2 < 0 && val2 > 2)) {
                    System.out.println("Seleciona o animal: ");
                    semException = true;
                    try {
                        val2 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Insira numero");
                        val2 = -1;
                        semException = false;
                    }
                }
                if (equipamento[val].getClass() == Consumivel.class) {
                    equipe.insereConsumivel(val2, (Consumivel) equipamento[val]);
                    equipamento[val] = null;
                } else {
                    equipe.insereEquipamento(val2, equipamento[val]);
                    equipamento[val] = null;

                }

            }
        }catch (NullPointerException e){
            System.out.println("Não está disponivel este item");
            semException = false;
        }

    }

    public void mostraLoja(){
        System.out.println("Dinheiro atual $: " + player.getDinheiro());
        for(Animal animis: animais){
            try{
                System.out.println(animis + "\t: " + animis.getPreco());
            }catch (NullPointerException e){
                System.out.println("X\t: X");
            }
        }
        for (Item item : equipamento){
            try {
                System.out.println(item + "\t: " + item.getPreco());
            }catch (NullPointerException e){
                System.out.println("X\t: X");
            }
        }
    }
    public void opcoesLoja(){
        System.out.println("O que você vai fazer?");
        System.out.println("A - Comprar Animal");
        System.out.println("I - Comprar Item");
        System.out.println("R - Para atualizar a loja");
        System.out.println("P - Ir para o próximo combate");

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
