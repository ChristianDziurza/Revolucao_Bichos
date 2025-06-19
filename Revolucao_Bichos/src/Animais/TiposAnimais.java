package Animais;

/**
 * Este Enum é utilizado para a geração de animais de uma maneira
 * mais universal e generica
 * @author Gabo K.S.
 * @version 0.2
 */

public enum TiposAnimais {
    PASSARO(5, 3, 1, "Passaro", 3,2){
        @Override
        public Animal setAams() {
             return new Passaro();
        }
    },
    GAIVOTA(7, 2, 1, "Gaivota", 3,2){
        @Override
        public Animal setAams() {
            return new Gaivota();
        }
    },
    DINOSSAURO(50, 1, 3, "Dinossauro", 1,7){
        @Override
        public Animal setAams() {
            return new Dinossauro();
        }
    },
    OVELHA(14, 2, 1, "Ovelha", 1,3){
        @Override
        public Animal setAams() {
            return new Ovelha();
        }
    },
    PEIXE(3, 1, 1, "Peixe", 2,1){
        @Override
        public Animal setAams() {
            return new Peixe();
        }
    },

    VOMBATE(20, 1, 4, "Vombate", 3,10){
        @Override
        public Animal setAams() { return new Vombate(); }
    };


    private int vida;
    private int dano;
    private int raridade;
    private int classificacao;
    private int preco;
    private String nome;
    private Animal aams;

    /**
     * Esse construtor inicializa os atributos de vida e dano.
     * Que vão ser usadas para a criação dos animais que vao ser
     * definidos dependendo do valor do enum que for chamado
     * @param vida1 que definira vida
     * @param dano1 que definira dano
     */
    TiposAnimais(int vida1, int dano1, int raridade, String nome, int classificacao, int preco){
        this.vida = vida1;
        this.dano = dano1;
        this.raridade = raridade;
        this.nome = nome;
        this.classificacao = classificacao;
        this.preco = preco;
    }

    /**
     * Este metódo foi criado com o intuito de sofrer um override
     * que define o tipo de subclasse do animal
     * @return se perguntarem pq tem um aams que nao é modificado
     * é porque o codigo nao funciona se nao tiver
     * (O new Animal nao funciona)
     */
    public Animal setAams() {
        return aams;
    }

    /**
     * Essa parte é a que realmente cria o animal definindo sua
     * subclasse e seus atributos
     * @return o objeto animal que define o tipo de animal na main
     */
    public Animal criaAnimal(){
        Animal animal = setAams();
        animal.setDano(dano);
        animal.setVida(vida);
        animal.setRaridade(raridade);
        animal.setNome(nome);
        animal.setVidatotal(vida);
        animal.setAtaqueTotal(dano);
        animal.setClassificacao(classificacao);
        animal.setPreco(preco);
        return animal;
    }

}
