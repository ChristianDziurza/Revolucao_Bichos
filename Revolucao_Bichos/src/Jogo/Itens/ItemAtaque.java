package Jogo.Itens;

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
    public void setPreco(int preco){this.preco = preco;}

    @Override
    public String toString(){
        return nome;
    }
}

