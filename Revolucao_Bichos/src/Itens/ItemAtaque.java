package Itens;

public class ItemAtaque implements Item {
    private int dano, preco;
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
    public int getPreco() {
        return preco;
    }

    @Override
    public String toString(){
        return nome;
    }
}

