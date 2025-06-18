import Animais.*;
import Itens.TipoItem;
import Jogo.Player;
import Jogo.Torneio;

import Jogo.Equipe;
import Jogo.EstadoCombate;

import java.util.*;
public class main {
    public static void main(String[] args) throws InterruptedException {
        int contadorRodada = 1;
        Player player = new Player();
        Equipe equipe1 = new Equipe();//gabo, tecnicamente era pra funcionar
        Equipe equipe2 = new Equipe();
        Torneio torneio = new Torneio(player, equipe1, equipe2);


        torneio.iniciaTorneio();

        System.out.println();



    }




}
