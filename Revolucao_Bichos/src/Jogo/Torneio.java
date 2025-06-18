package Jogo;

import Animais.Animal;
import Animais.TiposAnimais;

import java.util.Random;
import java.util.Scanner;

public class Torneio {
    private int contadorRodada=1;
    private boolean estado=true;
    private String c;
    private Loja loja;
    private EstadoCombate combate = new EstadoCombate();
    private Player player;
    private Equipe equipe;
    private Equipe equipeIn = new Equipe();
    Scanner scan = new Scanner(System.in);

    public Torneio(Player player, Equipe equipe, Equipe equipe2){
        this.player = player;
        this.equipe = equipe;
        player.criaArray(equipe2);
        equipeIn = equipe2;

    }

    public void trocaEstado(){
        if(estado)
            estado = false;
        else
            estado = true;
    }

    public void iniciaTorneio() throws InterruptedException {
        contadorRodada = 1;
        player.ganhaDinheiro(4);
        loja = new Loja(player);
        clearConsole();
        estadoLoja();
        loopTorneio();

    }
    public void loopTorneio() throws InterruptedException {
        int contando = 0;

        while(contando/2 < 3 && combate.isQmganho()) {
            contando++;
            if (estado) {
                player.criaArray(equipeIn);
                player.ganhaDinheiro(4);
                loja = new Loja(player);
                estadoLoja();
            } else {
                combate.iniciaCombate();
                combate.trocaEquipe(equipe, equipeIn);
                while (combate.getAtivo()) {
                    System.out.println("Rodada " + contadorRodada);
                    combate.rodada(equipe, equipeIn);
                    contadorRodada++;
                    clearConsole();
                }
                trocaEstado();
            }
        }
        fimDeJogo(combate.isQmganho());
        combate.setQmganho(true);
        iniciaTorneio();
    }

    public void fimDeJogo(boolean qmGanho){
        if(qmGanho){
            System.out.println("SUA EQUIEP VENCEU!!!!!!");
        }else{
            System.out.println("SUA EQUIPE PERDEU!!!!!");
            player.setDinheiro(0);
        }
    }


    public void estadoLoja(){
        while (estado) {
            loja.mostraLoja();
            loja.opcoesLoja();
            c = scan.nextLine();
            switch (c) {
                case "A":
                    loja.compraAnimal(equipe, player);
                    break;
                case "P":
                    trocaEstado();
                    break;
                case "I":
                    loja.compraEquipamento(equipe, player);
                    break;
                case "R":
                    loja.refresh();
                    break;
            }
            clearConsole();
        }
    }
    public final static void clearConsole()
    {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println("Error clearing the console: " + e.getMessage());
        }
    }

}
