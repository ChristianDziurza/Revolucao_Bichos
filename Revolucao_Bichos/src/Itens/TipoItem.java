package Itens;

public enum TipoItem {
    C_BANANA(3, 0, 2){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("Banana");
            return  it;
        }
    },
    C_COCO(0, 3, 2){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("Coco");
            return  it;
        }
    },
    A_ESPADABASICA(2,0,1){
        @Override
        public Item setItem() {//
            Item it = new ItemAtaque();
            ((ItemAtaque) it).setDano(getValDano());
            ((ItemAtaque) it).setNome("Espadinha");
            return it;
        }
    },
    D_GENERICO(0,1,1){
        @Override
        public Item setItem(){
            Item it = new ItemDefesa();
            ((ItemDefesa) it).setDefesa(getValDefesa());
            ((ItemDefesa) it).setNome("Genérico");
            return it;
        }
    },
    A_ESCUDO(0, 2, 1){
        @Override
        public Item setItem(){
            Item it = new ItemDefesa();
            ((ItemDefesa) it).setDefesa(getValDefesa());
            ((ItemDefesa) it).setNome("Escudinho");
            return it;
        }
    };

    private int val, val2, val3;
    private Item item;
    TipoItem(int val){
        this.val = val;
    }
    TipoItem(int val, int val2, int val3){
        this.val = val;
        this.val2 = val2;
        this.val3 = val3;

    }

    public int getValDano() {
        return val;
    }

    public int getValDefesa() {
        return val2;
    }

    public int getValPreco() {
        return val3;
    }

    public Item setItem(){
        return item;
    }
    public Item criaItem(){
        Item placeholder = setItem();
        placeholder.setPreco(val3);
        return  placeholder;
    }
}
