import Animais.*;
import Itens.TipoItem;
import Jogo.Equipe;
import Jogo.EstadoCombate;

import java.util.*;
public class main {
    public static void main(String[] args) {
        int contadorRodada = 1;
        EstadoCombate combate = new EstadoCombate();

        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        criaArray(equipe1);
        criaArray(equipe2);

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

        System.out.println();

        combate.iniciaCombate();
        while(combate.getAtivo()){
            System.out.println("Rodada "+contadorRodada);
            combate.rodada(equipe1,equipe2);
            contadorRodada++;

        }


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
