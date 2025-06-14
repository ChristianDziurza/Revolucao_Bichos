import Animais.*;
import Itens.TipoItem;
import Jogo.Equipe;

import java.util.*;
public class main {
    public static void main(String[] args) {
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        criaArray(equipe1);
        criaArray(equipe2);
        //é exatamente isso que eu vou fazer
        equipe1.insereEquipamento(0,TipoItem.A_ESPADABASICA.criaItem());
        equipe1.insereEquipamento(1,TipoItem.A_GENERICO.criaItem());
        equipe1.insereEquipamento(2,TipoItem.A_GENERICO.criaItem());
        equipe2.insereEquipamento(0,TipoItem.A_ESPADABASICA.criaItem());
        equipe2.insereEquipamento(1,TipoItem.A_GENERICO.criaItem());
        equipe2.insereEquipamento(2,TipoItem.A_GENERICO.criaItem());


        System.out.println("Animais A:");
        equipe1.imprimeEquipe();
        System.out.println();
        System.out.println("Animais B:");
        equipe2.imprimeEquipe();

        equipe1.alteraParty(0,1);
        equipe2.removeParty(1);
        System.out.println("Animais A:");
        equipe1.imprimeEquipe();
        System.out.println();//eu to pensando nisso, mas em qual classe
        System.out.println("Animais B:");
        equipe2.imprimeEquipe();

    }
    public static void criaArray(Equipe e1){
        Animal[] animasi = new Animal[3];
        TiposAnimais[] tipo = TiposAnimais.values();
        for(int i = 0; i<3; i++){
            Random rand = new Random();
            animasi[i] = tipo[rand.nextInt(tipo.length)].criaAnimal();
            e1.insereParty(i, animasi[i]);
        }
    }

}
