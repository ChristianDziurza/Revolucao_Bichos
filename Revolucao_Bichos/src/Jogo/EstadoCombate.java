package Jogo;

import Animais.*;

public class EstadoCombate {
    private boolean ativo = false;

    public void iniciaCombate(){
        ativo = true;
    }
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
        atacante.LevaDano((Integer) inimigo.Ataque());

        System.out.println("Vida de "+atacante+" após a batalha: "+atacante.getVida());
        System.out.println("Vida de "+inimigo+" após a batalha: "+inimigo.getVida());
    }
}
