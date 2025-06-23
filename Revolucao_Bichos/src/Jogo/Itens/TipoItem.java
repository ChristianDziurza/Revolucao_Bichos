package Jogo.Itens;

public enum TipoItem {
    C_BANANA(3, 0, 2){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("Banana de Batalha");
            return  it;
        }
    },
    C_LARANJA(2, 2, 3){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("Laranja?(defesa e ataque)");
            return  it;
        }
    },
    C_MACA(7, -2, 5){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("MAÇÃ PODEROSA");
            return  it;
        }
    },
    C_POCAO(10, -4, 8){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("POÇÃO PERIGOSA");
            return  it;
        }
    },
    C_COCO(0, 3, 2){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("Coco Defensivo");
            return  it;
        }
    },
    C_CASCO(0, 5, 4){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("C A S C O");
            return  it;
        }
    },
    C_FRAGMENTO(0, 11, 9){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("Fragmento Antigo");
            return  it;
        }
    },
    C_HA(-5, 15, 14){
        @Override
        public Item setItem(){
            Item it = new Consumivel(getValDano(), getValDefesa());
            ((Consumivel) it).setNome("DEFESA IMPLACAVEL");
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
    A_ESPADAINCRIVEL(4,0,5){
        @Override
        public Item setItem() {//
            Item it = new ItemAtaque();
            ((ItemAtaque) it).setDano(getValDano());
            ((ItemAtaque) it).setNome("Espada Incrivel");
            return it;
        }
    },
    A_LENDARIA(8,0,10){
        @Override
        public Item setItem() {//
            Item it = new ItemAtaque();
            ((ItemAtaque) it).setDano(getValDano());
            ((ItemAtaque) it).setNome("Espada L E N D Á R I A");
            return it;
        }
    },
    D_GENERICO(0,1,1){
        @Override
        public Item setItem(){
            Item it = new ItemDefesa();
            ((ItemDefesa) it).setDefesa(getValDefesa());
            ((ItemDefesa) it).setNome("Ajudinha");
            return it;
        }
    },
    A_ESCUDAO(0,4,3){
        @Override
        public Item setItem(){
            Item it = new ItemDefesa();
            ((ItemDefesa) it).setDefesa(getValDefesa());
            ((ItemDefesa) it).setNome("Escudão!!");
            return it;
        }
    },
    A_ESCUDOANTIGO(0,6,5){
        @Override
        public Item setItem(){
            Item it = new ItemDefesa();
            ((ItemDefesa) it).setDefesa(getValDefesa());
            ((ItemDefesa) it).setNome("Escudo Antigo!!");
            return it;
        }
    },
    A_ESCUDONOVO(0,8,7){
        @Override
        public Item setItem(){
            Item it = new ItemDefesa();
            ((ItemDefesa) it).setDefesa(getValDefesa());
            ((ItemDefesa) it).setNome("Escudo de Fábrica!!");
            return it;
        }
    },
    A_ESCUDOPERFEITO(0,12,11){
        @Override
        public Item setItem(){
            Item it = new ItemDefesa();
            ((ItemDefesa) it).setDefesa(getValDefesa());
            ((ItemDefesa) it).setNome("Escudo P E R F E I T O!!");
            return it;
        }
    },
    A_ESCUDO(0, 2, 1){
        @Override
        public Item setItem(){
            Item it = new ItemDefesa();
            ((ItemDefesa) it).setDefesa(getValDefesa());
            ((ItemDefesa) it).setNome("Escudinho!!");
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
