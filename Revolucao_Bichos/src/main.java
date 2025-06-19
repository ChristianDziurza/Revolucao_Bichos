import Animais.*;
import Itens.TipoItem;
import Jogo.*;

import java.io.IOException;
import java.util.*;
public class main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Player player = new Player();
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        Torneio torneio = new Torneio(player, equipe1, equipe2);
        Menu menu = new Menu(torneio);
        try {
            while (true) {
                menu.Escolha();
            }
        }catch (Exception e){

        }


    }




}
