package Jogo.Itens;

public class ItemDefesa implements Item{
    private int defesa, preco;
    private String nome;

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public Integer Efeito() {//
        return defesa;
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
