package Jogo;

import Animais.*;

public class EstadoCombate {
    private boolean ativo = false;

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
        System.out.println("Combate entre: ");
        System.out.print(atacante);
        System.out.println(" e "+inimigo);
        System.out.println("Vida de "+atacante+" antes da batalha: "+atacante.getVida());
        System.out.println("Vida de "+inimigo+" antes da batalha: "+inimigo.getVida());

        inimigo.LevaDano((Integer) atacante.Ataque());
        if (inimigo.getVida()<=0){
            inimigo.setMorto(true);
            System.out.println(inimigo + " morreu");
            System.out.println(inimigo.isMorto());
        }
        atacante.LevaDano((Integer) inimigo.Ataque());
        if (atacante.getVida()<=0){
            atacante.setMorto(true);
            System.out.println(atacante + " morreu");

        }

        System.out.println("Vida de "+atacante+" após a batalha: "+atacante.getVida());
        System.out.println("Vida de "+inimigo+" após a batalha: "+inimigo.getVida());

        if (eqp.allMorto()){
            System.out.println("Todos integrantes da " + eqp + "Morreram");
            System.out.println("O combate terminou");
            terminaCombate();
        }
        if (inim.allMorto()){
            System.out.println("Todos integrantes da " + inim + "Morreram");
            System.out.println("O combate terminou");
            terminaCombate();
        }
    }
}
