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

    public void iniciaTorneio(){
        contadorRodada = 1;
        player.ganhaDinheiro(4);

        loja = new Loja(player);
        estadoLoja();


    }
    public void loopTorneio(){
        int contando = 0;
        while(contando/2 < 3) {
            contando++;
            if (estado) {
                player.ganhaDinheiro(4);
                loja = new Loja(player);
                estadoLoja();
            } else {
                combate.iniciaCombate();
                while (combate.getAtivo()) {
                    System.out.println("Rodada " + contadorRodada);
                    combate.rodada(equipe, equipeIn);
                    contadorRodada++;
                }
                trocaEstado();
            }
        }
    }



    public void estadoLoja(){
        while (estado) {
            loja.mostraLoja();
            loja.opcoesLoja();
            c = scan.nextLine();
            switch (c) {
                case "A":
                    System.out.println();
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
        }
    }

}
