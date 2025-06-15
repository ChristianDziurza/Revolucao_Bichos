package Itens;

import Jogo.Inteiros;

public class Consumivel implements Item{
    private boolean emUso=true;
    private int dano;
    private int defesa;

    public Consumivel(int dano, int defesa){
        this.dano = dano;
        this.defesa = defesa;
    }

    public boolean geItemUso(){
        return emUso;
    }

    public void fimDeUso(){
        emUso=false;
    }
    @Override
    public Inteiros Efeito() {//não é C, não tem os meus amados ponteiros
        return new Inteiros(dano, defesa);
    }

}
