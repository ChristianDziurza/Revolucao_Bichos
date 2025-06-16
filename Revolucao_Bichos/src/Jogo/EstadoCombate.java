package Jogo;

import Animais.*;

public class EstadoCombate {
    private boolean ativo = false, mortoAl=true, mortoIn=true;

    public void iniciaCombate(){
        ativo = true;
    }

    public boolean getAtivo(){
        return ativo;
    }
    public void terminaCombate(){ ativo = false;}

    public void rodada(Equipe eqp, Equipe inim){
        Animal atacante, inimigo;
        atacante = eqp.primeiroAnimal();
        inimigo = inim.primeiroAnimal();
        if(mortoAl == true){
            System.out.println("Ativando efeitos do aliado "+atacante);
            if(atacante.getClassificacao() == 3){
                atacante.IniciaTurno();
            }else if(atacante.getClassificacao() == 1){
                atacante.IniciaTurno(eqp.getAnimais(), atacante);
            }else{
                atacante.IniciaTurno(inimigo);
            }
            mortoAl = false;
        }
        if(mortoIn == true){
            System.out.println("Ativando efeitos do inimigo "+inimigo);
            if(inimigo.getClassificacao() == 3){
                inimigo.IniciaTurno();
            }else if(inimigo.getClassificacao() == 1){
                inimigo.IniciaTurno(eqp.getAnimais(), atacante);
            }else{
                inimigo.IniciaTurno(inimigo);
            }
            mortoIn = false;
        }
        System.out.println("Combate entre: ");
        System.out.print(atacante);
        System.out.println(" e "+inimigo);
        System.out.println("Vida de "+atacante+" antes da batalha: "+atacante.getVida());
        System.out.println("Vida de "+inimigo+" antes da batalha: "+inimigo.getVida());



        inimigo.LevaDano((Integer) atacante.Ataque());
        if (inimigo.getVida()<=0){
            inimigo.setMorto(true);
            mortoIn = true;
            System.out.println(inimigo + " morreu");
            System.out.println(inimigo.isMorto());
        }
        atacante.Especial(inimigo);
        atacante.LevaDano((Integer) inimigo.Ataque());
        if (atacante.getVida()<=0){
            atacante.setMorto(true);
            mortoAl = true;
            System.out.println(atacante + " morreu");

        }
        inimigo.Especial(atacante);

        System.out.println("Vida de "+atacante+" após a batalha: "+atacante.getVida());
        System.out.println("Vida de "+inimigo+" após a batalha: "+inimigo.getVida());

        if (eqp.allMorto()){
            System.out.println("Sua equipe já era :(");
            System.out.println("O combate terminou");
            terminaCombate();
        }
        if (inim.allMorto()){
            System.out.println("Todos os inimigos foram obliterados :)");
            System.out.println("O combate terminou");
            terminaCombate();
        }
    }
}
