package Animais;
import Itens.*;
import java.util.*;

public abstract class Animal {
    int vida, overhealth, raridade, preco, classificacao, vidatotal;
    String nome;
    Number dano;
    boolean morto;
    Item equipamento;
    List<Consumivel> consumivel = new ArrayList<>();

    public Item getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Item equipamento) {
        this.equipamento = equipamento;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

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

    public int getClassificacao() {return classificacao;}

    public void setClassificacao(int classificacao) {this.classificacao = classificacao;}

    public void setOverhealth(int overhealth) {
        this.overhealth = overhealth;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public void setDano(Number dano) {
        this.dano = dano;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void addConsumivel(Item consumivel1) {
        this.consumivel.add((Consumivel) consumivel1);
    }

    public Number getDano() {return dano;}

    public Number Ataque(){
        int danoTotal = dano.intValue();
        try {
            if (equipamento.getClass() == ItemAtaque.class) {//
                danoTotal += equipamento.Efeito().intValue();
            }
        }catch (NullPointerException e){

        }
        try {
            for (Consumivel consumivel1 : consumivel) {
                if (consumivel1.geItemUso()) {
                    System.out.println("TEM CONSUMIVEL");
                    danoTotal += consumivel1.Efeito().intsValue()[0];
                }
            }
        }catch(NullPointerException e){
            System.out.println("Não tem consumivel");
        }

        return (Integer) danoTotal;

    }
    public boolean Morte(){
        vida = vidatotal;
        morto = true;
        return morto;
    }
    @Override
    public String toString(){
        return nome;
    }

    public void IniciaTurno(){}
    public void IniciaTurno(Animal[] animal, Animal pos){}
    public void IniciaTurno(Animal inim){}
    public abstract void LevaDano(int x);

    public abstract void Especial(Animal inim);


}
