package Jogo.Animais;
import Jogo.Equipe;
import Jogo.Itens.*;
import java.util.*;

public abstract class Animal extends Equipe {
    int vida, overhealth, raridade, preco, classificacao, vidatotal, ataqueTotal, nivel;
    String nome;
    Number dano;
    boolean morto;
    Item equipamento;
    List<Consumivel> consumivel = new ArrayList<>();

    public List<Consumivel> getConsumivel() {
        return consumivel;
    }

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

    public int getNivel(){return nivel;}

    public void setNivel(int nivel){this.nivel = nivel; vidatotal = vidatotal + (2*nivel); vida = vidatotal;}

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

    public void setVidatotal(int vidatotal) {
        this.vidatotal = vidatotal;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void addConsumivel(Item consumivel1) {
        this.consumivel.add((Consumivel) consumivel1);
    }

    public void setAtaqueTotal(int ataqueTotal) {
        this.ataqueTotal = ataqueTotal;
    }

    public Number getDano() {return dano;}

    public Number Ataque(){
        int danoTotal = dano.intValue() + (2*getNivel());
        try {
            if (equipamento.getClass() == ItemAtaque.class) {//
                danoTotal += equipamento.Efeito().intValue();
            }
        }catch (NullPointerException e){

        }
        try {
            for (Consumivel consumivel1 : consumivel) {
                if (consumivel1.geItemUso()) {
                    danoTotal += consumivel1.Efeito().intsValue()[0];
                }
            }
        }catch(NullPointerException e){
        }

        return (Integer) danoTotal;

    }
    public void fimDeUso(){
        for (Consumivel consumivel1 : consumivel) {
            if (consumivel1.geItemUso()) {
                consumivel1.fimDeUso();
            }
        }
    }
    public void iniciaVida(){
        int overhealthtotal = 0;
        vida = vidatotal;
        dano = ataqueTotal;
        try {
            if (getEquipamento().getClass() == ItemDefesa.class) {
                overhealthtotal += getEquipamento().Efeito().intValue();
            }
        }catch (NullPointerException e){

        }
        try {
            for (Consumivel consumivel1 : consumivel) {
                if (consumivel1.geItemUso()) {
                    overhealthtotal += consumivel1.Efeito().intsValue()[1];
                }
            }
        }catch(NullPointerException e){
        }
        setOverhealth(overhealthtotal);
        System.out.println("Não");
    }
    public int checaSobreVida(int x) {
        if (getOverhealth() > 0) {
            int overheal = getOverhealth() - x;
            if (overheal > 0) {
                setOverhealth(overheal);
                x = 0;
            } else {
                setOverhealth(0);
                x = overheal * -1;
            }
        }
        return x;
    }
    public boolean Morte(){
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
