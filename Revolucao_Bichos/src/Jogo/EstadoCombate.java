package Jogo;

import Animais.*;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EstadoCombate {
    private boolean ativo = false, mortoAl=true, mortoIn=true, qmganho = true;
    int mortecont = 0, morteinimcont = 0;
    String mortes = "Quantidade de aliados mortos: "+mortecont, mortos="Quantidade de inimigos mortos: "+morteinimcont;

    public void iniciaCombate(){
        ativo = true;
    }

    public void setMorteinimcont(int morteinimcont) {
        this.morteinimcont = morteinimcont;
    }

    public void setMortecont(int mortecont) {
        this.mortecont = mortecont;
    }

    public void setQmganho(boolean qmganho) {
        this.qmganho = qmganho;
    }

    public int getMortecont() {
        return mortecont;
    }

    public int getMorteinimcont() {
        return morteinimcont;
    }

    public boolean isQmganho(){ return qmganho;}
    public boolean getAtivo(){
        return ativo;
    }
    public void terminaCombate(Equipe eqp){
        mortoAl = true;
        mortoIn = true;
        for(int i = 0; i<3; i++){
            try {
                eqp.getAnimais()[i].setMorto(false);
                eqp.getAnimais()[i].fimDeUso();
            }catch (NullPointerException e){

            }
        }
        ativo = false;
    }

    /**
     * Esté método é responsável por todo o sistema de rodadas dos combates
     * ele também é responsável por fazer a chamada das ativações dos efeitos
     * dos animais, tanto inimigos quanto aliados. Todas as condições de
     * chegagem para efeitos, dano e morte são feitas aqui
     * @param eqp equipe do jogador
     * @param inim equipe inimiga
     */
    public void rodada(Equipe eqp, Equipe inim) throws InterruptedException {
        Animal atacante, inimigo;
        atacante = eqp.primeiroAnimal();//já volto
        inimigo = inim.primeiroAnimal();
        if(mortoAl == true){
            System.out.println("Ativando efeitos do aliado "+atacante);
            if (atacante.getClassificacao() == 3) {
                atacante.IniciaTurno();
            } else if (atacante.getClassificacao() == 1) {
                atacante.IniciaTurno(eqp.getAnimais(), atacante);
            } else {
                atacante.IniciaTurno(inimigo);
            }
            mortoAl = false;
        }
        if(mortoIn == true){
            System.out.println("Ativando efeitos do inimigo "+inimigo);
            if(inimigo.getClassificacao() == 3){
                inimigo.IniciaTurno();
            }else if(inimigo.getClassificacao() == 1){
                inimigo.IniciaTurno(inim.getAnimais(), inimigo);
            }else{
                inimigo.IniciaTurno(inimigo);
            }
            mortoIn = false;
        }
        System.out.println("Combate entre: ");
        System.out.print(atacante);
        System.out.println(" e "+inimigo);
        System.out.println("Vida de "+atacante+" antes da batalha: "+atacante.getVida() + " " + atacante.getOverhealth());
        System.out.println("Vida de "+inimigo+" antes da batalha: "+inimigo.getVida() + " " + inimigo.getOverhealth());
        Thread.sleep(750);


        atacante.Especial(inimigo);
        inimigo.Especial(atacante);
        inimigo.LevaDano((Integer) atacante.Ataque());
        if (inimigo.getVida()<=0){
            inimigo.setMorto(true);
            mortoIn = true;
            System.out.println(inimigo + " morreu");
            morteinimcont++;
        }
        atacante.LevaDano((Integer) inimigo.Ataque());
        if (atacante.getVida()<=0){
            atacante.setMorto(true);
            mortoAl = true;
            System.out.println(atacante + " morreu");
            mortecont++;

        }

        System.out.println("Vida de "+atacante+" após a batalha: "+atacante.getVida() + " " + atacante.getOverhealth());
        System.out.println("Vida de "+inimigo+" após a batalha: "+inimigo.getVida() + " " + inimigo.getOverhealth());
        Thread.sleep(750);

        if (eqp.allMorto()){
            System.out.println("Sua equipe já era :(");
            System.out.println("O combate terminou");
            qmganho = false;
            Thread.sleep(1500);
            terminaCombate(eqp);
        }
        if (inim.allMorto()){
            System.out.println("Todos os inimigos foram obliterados :)");
            System.out.println("O combate terminou");
            qmganho = true;
            Thread.sleep(1500);
            terminaCombate(eqp);
        }
    }

    public void trocaEquipe(Equipe aliada, Equipe inimiga){
        boolean dowhile = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("A equipe adversaria: ");
        for(Animal e : inimiga.getAnimais()){
            if(e != null) {
                System.out.println(e);
            }else{
                System.out.println("X");
            }
        }

        while (dowhile) {
            System.out.println("Deseja trocar posicao da sua equipe?");
            String scan = scanner.nextLine();
            switch (scan) {
                case "S":
                    aliada.imprimeEquipe();
                    System.out.println("Insira as posicoes que deseja que sejam trocadas");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    aliada.alteraParty(x, y);
                    break;
                case "N":
                    System.out.println("Oka");
                    dowhile = false;
                    break;
            }
        }
    }
}
