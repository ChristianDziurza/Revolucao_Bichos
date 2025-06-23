package Jogo;

import Animais.Animal;
import Animais.TiposAnimais;

import java.io.IOException;
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
    private Equipe equipeIn;
    private Estatistica estatistica = new Estatistica();
    Scanner scan = new Scanner(System.in);

    public Torneio(Player player, Equipe equipe, Equipe equipe2){
        this.player = player;
        this.equipe = equipe;
        equipe2.inserePartyNormal();
        equipeIn = equipe2;

    }
    /**
     * Este método é responsável por trocar o estado do jogo
     * ele troca entre os estados de combate e loja
     */

    public void trocaEstado(){
        if(estado)
            estado = false;
        else
            estado = true;
    }

    public void iniciaTorneio() throws InterruptedException, IOException {
        contadorRodada = 1;

        player.ganhaDinheiro(7);
        estatistica.addDinTotal(7);
        loja = new Loja(player);
        Ui.clearConsole();
        estadoLoja();
        loopTorneio();

    }
    public void loopTorneio() throws InterruptedException, IOException {
        int contando = 0;

        while(contando/2 < 3 && combate.isQmganho()) {
            contando++;
            equipeIn.inserePartyNormal();
            if (estado) {
                player.ganhaDinheiro(4);
                estatistica.addDinTotal(4);
                loja = new Loja(player);
                estadoLoja();
            } else {
                combate.iniciaCombate();
                combate.trocaEquipe(equipe, equipeIn);
                while (combate.getAtivo()) {
                    System.out.println("Rodada " + contadorRodada);
                    combate.rodada(equipe, equipeIn);
                    contadorRodada++;
                    Ui.clearConsole();
                }
                estatistica.setAnimaisMorto(combate.getMortecont());
                estatistica.addInimAbatidos(combate.getMorteinimcont());
                combate.setMorteinimcont(0);
                combate.setMortecont(0);
                trocaEstado();
            }
        }
        estatistica.addEstMortes(1);
        fimDeJogo(combate.isQmganho());
        Thread.sleep(1750);
        equipe.apagaParty();
        combate.setQmganho(true);

    }

    public void fimDeJogo(boolean qmGanho) throws IOException {
        if(qmGanho){
            System.out.println("SUA EQUIPE VENCEU!!!!!!");
        }else{
            System.out.println("SUA EQUIPE PERDEU!!!!!");
            player.setDinheiro(0);
        }
        estatistica.Update();
    }


    public void estadoLoja() throws InterruptedException {
        while (estado) {
            loja.mostraLoja();
            Ui.opcoesLoja();
            c = scan.nextLine();
            switch (c) {
                case "A":
                    loja.compraAnimal(equipe, player);
                    Thread.sleep(2000);
                    break;
                case "P":
                    trocaEstado();
                    break;
                case "I":
                    loja.compraEquipamento(equipe, player);
                    Thread.sleep(2000);
                    break;
                case "R":
                    loja.refresh();
                    break;
                case "E":
                    equipe.imprimeEquipe();
                    Thread.sleep(3000);
                    break;
                case "S":
                    loja.VenderAnimal(equipe, player);
                    Thread.sleep(2000);
                    break;
            }
            Ui.clearConsole();
        }
    }



}
