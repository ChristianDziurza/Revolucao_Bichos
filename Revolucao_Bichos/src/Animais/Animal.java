package Animais;
import Itens.*;

public abstract class Animal {
    int vida, dano, overhealth;
    boolean morto;
    Item item;

    //ta, por agora a gente precisa de uma main, de criar os vetores e preencher e dai
    //fazer uma simulaçao de combate, só pra ter um prototipo pq dai a parte dos vetores
    //vai pra uma classe própria ou metodo pra ficar melhor e o combate tambem
    //to klskjkjsjksjsk
    //é que quando voce abre uma janela diferente eu não posso fazer nada



    public int getOverhealth() {
        return overhealth;
    }

    public void setOverhealth(int overhealth) {
        this.overhealth = overhealth;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int Ataque(){
        return dano;
    }

    public abstract void LevaDano(int x);
    public abstract void Morte();
    public abstract void Especial();

}
