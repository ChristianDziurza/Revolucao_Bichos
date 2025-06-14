package Itens;

public enum TipoItem {
    C_BANANA(3, 0){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getVal(), getVal2());
            return  it;
        }
    },
    A_ESPADABASICA(2){
        @Override
        public Item setItem() {//
            Item it = new ItemAtaque();
            ((ItemAtaque) it).setDano(getVal());
            ((ItemAtaque) it).setNome("Espadinha");
            return it;
        }
    },
    A_GENERICO(2){
        @Override
        public Item setItem(){
            Item it = new ItemAtaque();
            ((ItemAtaque) it).setDano(getVal());
            ((ItemAtaque) it).setNome("Genérico");//roda
            return it;
        }
    };

    private int val, val2;
    private Item item;
    TipoItem(int val){
        this.val = val;
    }
    TipoItem(int val, int val2){
        this.val = val;
        this.val2 = val2;
    }

    public int getVal() {
        return val;
    }

    public int getVal2() {
        return val2;
    }

    public Item setItem(){
        return item;
    }
    public Item criaItem(){
        Item placeholder = setItem();
        return  placeholder;
    }
}
