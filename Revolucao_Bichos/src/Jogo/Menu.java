package Jogo;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Torneio torneio;

    public Menu(Torneio torneio){
        this.torneio = torneio;
    }

    public void Escolha() throws InterruptedException, IOException {
        Ui.clearConsole();
        Ui.menuUi();
        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.nextLine();
        switch (escolha){
            case "1":
                torneio.iniciaTorneio();
                break;
            case "2":
                //Estatisticas();
                break;
            case "3":
                throw new RuntimeException() ;
        }
    }
    /*
    public void Estatisticas(){

    }
     */
}
