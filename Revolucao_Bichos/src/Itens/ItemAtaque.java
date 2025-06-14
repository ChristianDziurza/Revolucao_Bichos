package Itens;

public class ItemAtaque implements Item {
    private int dano;
    private String nome;

    public void setDano(int dano) {
        this.dano = dano;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public Integer Efeito() {//
        return dano;
    }

    @Override
    public String toString(){
        return nome;
    }
}

