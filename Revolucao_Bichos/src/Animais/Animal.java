package Animais;
import Itens.*;
import java.util.*;

public abstract class Animal {
    int vida, overhealth, raridade, preco;
    Number dano;
    boolean morto;
    Item equipamento;
    List<Consumivel> consumivel;

    public Item getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Item equipamento) {
        this.equipamento = equipamento;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getRaridade() {
        return raridade;
    }

    public void setRaridade(int raridade) {
        this.raridade = raridade;
    }

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

    public Number Ataque(){
        Integer danoTotal = dano.intValue();
        if(equipamento.getClass() == ItemAtaque.class){//
            danoTotal += equipamento.Efeito().intValue();
        }
        for(Consumivel consumivel1: consumivel) {
            if (consumivel1.geItemUso() == true) {
                danoTotal += consumivel1.Efeito().intsValue()[0];
            }
        }
        return danoTotal;

    }

    public abstract void IniciaTurno();
    public abstract void LevaDano(int x);
    public abstract void Morte();
    public abstract void Especial();

}
