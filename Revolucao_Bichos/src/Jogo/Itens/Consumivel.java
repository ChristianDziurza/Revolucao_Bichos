package Jogo.Itens;

import Jogo.Inteiros;

public class Consumivel implements Item{
    private boolean emUso=true;
    private int dano;
    private int defesa;
    private int preco;
    private String nome;

    public Consumivel(int dano, int defesa){
        this.dano = dano;
        this.defesa = defesa;
    }

    public boolean geItemUso(){
        return emUso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void fimDeUso(){
        emUso=false;
    }
    @Override
    public Inteiros Efeito() {//não é C, não tem os meus amados ponteiros
        return new Inteiros(dano, defesa);
    }

    @Override
    public int getPreco() {
        return preco;
    }

    @Override
    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public String toString(){
        return nome;
    }

}
