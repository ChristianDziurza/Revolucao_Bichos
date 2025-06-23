package Jogo;
import Jogo.Animais.*;
import Jogo.Exceptions.AnimalNuloException;
import Jogo.Exceptions.EstouraWhileException;
import Jogo.Exceptions.ItemNuloException;
import Jogo.Itens.*;

import java.util.Random;
import java.util.Scanner;

/**
 * Esta classe foi feita com a função de manipular a equipe do jogador
 * @author Gabo K.S.
 * @version 2.0
 */


public class Equipe {
    private Animal[] animais = new Animal[3];


    /**
     * Esse método verifica se a equipe está cheia
     *
     * @return o boleano da verificação
     */
    public boolean isFull() {
        boolean isfull = true;
        for (Animal animal : animais) {
            if (animal == null) {
                isfull = false;
            }
        }
        return isfull;
    }

    /**
     * Neste método verifica se a equipe tem mais de um membro para trocas
     * ou remoção de membros
     *
     * @return o boleano da equação
     */
    public boolean maisDeUm() {
        boolean temMaisDeUm = true;
        int maxParty = 3;
        for (Animal animal : animais) {
            if (animal == null) {
                maxParty--;
            }
        }
        if (!(maxParty > 1))
            temMaisDeUm = false;
        return temMaisDeUm;
    }

    /**
     * Esse método foi feito com o principio de adicionar animais a equipe
     * ele utiliza método de verificação se cheio para não ter problemas após
     * e também utiliza recursão
     *
     * @param pos    é a posição do vetor
     * @param animal é o animal que seria colocado na posição do vetor
     */
    public void insereParty(int pos, Animal animal) {
        Scanner scanner = new Scanner(System.in);
        if (isFull()) {
            boolean remover = true;
            for(int i = 0; i<3; i++){
                if(animais[i].getClass() == animal.getClass()){
                    System.out.println("Gostaria de melhorar o animal: " + animais[i]);
                    String scan = scanner.nextLine();
                    if(scan.equals("S") || scan.equals("s")){
                        animais[i].setNivel((animais[i].getNivel() + 1));
                        remover = false;
                    }
                }
            }
            if(remover) {
                System.out.println("Party cheia!!!!!\n" + "Não é possível adicionar um animal, gostaria de remover algum?");
                char c = scanner.next().charAt(0);
                if (c == 'S' || c == 's') {
                    System.out.println("Insira qual animal quer tirar");
                    imprimeEquipe();
                    int pos2 = scanner.nextInt();
                    removeParty(pos2);
                    insereParty(pos, animal);
                }
            }
        } else {
            boolean semExecption = false;
            while (!semExecption) {
                semExecption = true;

                /**
                 * Faz a verificação se foi inserido um número certo.
                 * @exception ArrayIndexOutOfBoundsException
                 */
                try {
                    if (animais[pos] == null) {
                        animais[pos] = animal;
                        System.out.println("Animal inserido com sucesso!!!!");
                    } else if (animais[pos].getClass() == animal.getClass()){
                        animais[pos].setNivel(animais[pos].getNivel()+1);
                        System.out.println("Nivel do animal aumentado");
                    }else {
                        System.out.println("Ja esta ocupado");

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("O valor de pos está fora do escopo!!!!\n" + "Insira um novo valor:");

                    pos = scanner.nextInt();
                    semExecption = false;
                }
            }

        }
    }

    /**
     * Esse método foi criado com a intenção de alterar a posição dos animais entre si
     * utiliza a verificação de maisDeUm para não ter problemas em trocar com vazio
     *
     * @param pos1 posição do animal1
     * @param pos2 posição do animal2
     */
    public void alteraParty(int pos1, int pos2) {
        Scanner scanner = new Scanner(System.in);

        if (maisDeUm()) {
            boolean semExecption1 = false;
            boolean semExecption2 = false;
            Animal aux;
            while (!semExecption1) {
                semExecption1 = true;
                /**
                 * Faz a verificação se foi inserido um número certo.
                 * @exception ArrayIndexOutOfBoundsException
                 */
                try {
                    aux = animais[pos1];
                    while (!semExecption2) {
                        semExecption2 = true;

                        /**
                         * Faz a verificação se foi inserido um número certo.
                         * @exception ArrayIndexOutOfBoundsException
                         */
                        try {
                            animais[pos1] = animais[pos2];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("O valor de pos2 está fora do escopo!!!!\n" + "Insira um novo valor:");
                            pos2 = scanner.nextInt();
                            semExecption2 = false;
                        }
                    }
                    animais[pos2] = aux;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("O valor de pos1 está fora do escopo!!!!\n" + "Insira um novo valor:");
                    pos1 = scanner.nextInt();
                    semExecption1 = false;
                }
            }
            System.out.println("Jogo.Animais reposicionados");
        } else {
            System.out.println("Não tem animais o suficiente");
        }
    }

    /**
     * Aqui esse método é pra tirar animais da equipe
     * utiliza a verifição de maisDeUm para não deixar a equipe vazia
     * é só uma questão de segurança para players não removerem membros e
     * perderem por causa disso
     *
     * @param pos posição do animal que vai ser retirado
     */
    public void removeParty(int pos) {

        boolean semExecption = false;
        while (!semExecption) {
            semExecption = true;
            /**
            * Faz a verificação se foi inserido um número certo.
            * @exception ArrayIndexOutOfBoundsException
            */
            try {
                animais[pos] = null;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("O valor da posição está fora do escopo!!!!\n" + "Insira um novo valor:");
                Scanner scanner = new Scanner(System.in);
                pos = scanner.nextInt();
                semExecption = false;
            }
        }
        System.out.println("Animal vendido");

    }

    /**
     * Este método tem a função de inserir equipamento(cada animal só pode ter um)
     * em um animal, este equipamento pode ser tanto um defensivo quanto um ofensivo
     * por esta dualidade é usado a Interface item para seu uso.
     * @param pos é a posição do animal escolhido
     * @param equipamento é o tipo de equipamento que vai ser inserido
     */
    public void insereEquipamento(int pos, Item equipamento) {
        boolean semException = false;
        Scanner scanner = new Scanner(System.in);
        while (!semException) {
            semException = true;
            /**
             * Faz a verificação se foi inserido um número certo e se o animal é nulo.
             * @exception ArrayIndexOutOfBoundsException
             * @exception AnimalNuloException
             */
            try {
                if ((animais[pos] == null))
                    throw new AnimalNuloException();
                animais[pos].setEquipamento(equipamento);
                System.out.println("Inserido com sucesso");

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Insira um numero adequado");
                pos = scanner.nextInt();
                semException = false;
            } catch (AnimalNuloException e){
                System.out.println(e);
            }
        }
    }

    /**
     * Este método é responsável pela inserção de consumíveis(podem ser mais de 1) nos animais
     * que serão aplicados no inicio de cada rodada
     * @param pos posição do animal
     * @param consumivel as caracteristicas do consumível
     */
    public void insereConsumivel(int pos, Consumivel consumivel) {
        boolean semException = false;
        Scanner scanner = new Scanner(System.in);
        while (!semException) {
            semException = true;
            /**
             * Faz a verificação se foi inserido um número certo e se o animal é nulo.
             * @exception ArrayIndexOutOfBoundsException
             * @exception AnimalNuloException
             */
            try {
                if ((animais[pos] == null))
                    throw new AnimalNuloException();
                animais[pos].addConsumivel(consumivel);
                System.out.println("Inserido com sucesso");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Insira um numero adequado");
                pos = scanner.nextInt();
                semException = false;
            } catch (AnimalNuloException e){
                System.out.println(e);
            }
        }

    }

    /**
     * Neste método é realizado a impressão dos animais que compoem a equipe, juntamente
     * com seus itens
     */
    public void imprimeEquipe() {

        for (int i = 0; i<3; i++) {
            /**
             * Faz a verificação se foi inserido um número certo e se o animal é nulo.
             * @exception ArrayIndexOutOfBoundsException
             * @exception AnimalNuloException
             */
            try {
                System.out.print("Animal: ");
                System.out.println(animais[i]);
                System.out.println("Vida: "+animais[i].getVida());
                System.out.print("Nível: ");
                System.out.println(animais[i].getNivel());
                for(Consumivel cos: animais[i].getConsumivel()){
                    if(cos.geItemUso())//
                        System.out.println("Consumível: " + cos);
                }
                System.out.print("Equipamento: ");
                if (animais[i].getEquipamento() == null)
                    throw new ItemNuloException();
                System.out.println(animais[i].getEquipamento());
            } catch (NullPointerException e) {
                System.out.println("Não tem ninguém");
            } catch (ItemNuloException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Este método é utilizado para obter o primeiro animal atual, isto é, desconsiderar os animais
     * que acabaram morrendo durante o combate, um meio de ordenar o vetor
     * @return o animal que vai batalhar no momento
     * @author Christian D.C.
     */
    public Animal primeiroAnimal() {
        Animal pos;
        boolean dowhile = true;
        int i = 0;
        pos = animais[i];
        /**
         * Se o vetor estourar lançar um
         * @exception EstouraWhileException
         */
        try {
            while (dowhile) {
                dowhile = false;
                /**
                 * Tratar as exceções se o ponteiro for nulo e se o Array estourar
                 * @exception NullPointerException
                 * @exception ArrayIndexOutOfBoundsException
                 */
                try {
                    while (animais[i].isMorto()) {
                        i++;
                        pos = animais[i];
                    }
                } catch (NullPointerException e) {
                    i++;
                    pos = animais[i];
                    dowhile = true;
                }catch (ArrayIndexOutOfBoundsException e){
                    throw new EstouraWhileException();
                }
            }
        }catch (EstouraWhileException e){}

        return pos;
    }

    /**
     * Realiza a verificação se todos os membros da equipe foram derrotados
     * @return um boleano que indica se a equipe foi derrotada ou não
     * @author Lu
     */
    public boolean allMorto() {
        for (Animal animal : animais) {
            /**
             * Verifica se todo animal está vivo, caso não tenha um animal ele pula o animal
             * @exception NullPointerException
             */
            try {
                if (!animal.isMorto()) {
                    return false;
                }
            } catch (NullPointerException e) {

            }
        }
        return true;
    }

    public Animal[] getAnimais() {
        return animais;
    }

    public void inserePartyNormal() {
        Animal[] animasi = new Animal[3];
        boolean animalPossivel = true;
        TiposAnimais[] tipo = TiposAnimais.values();
        apagaParty();
        for(int i = 0; i<3; i++){
            Random rand = new Random();

            if(animalPossivel) {
                animasi[i] = tipo[rand.nextInt(tipo.length)].criaAnimal();
                animais[i] = animasi[i];
            }
            if(rand.nextInt(2) == 0){
                animalPossivel = false;
            }else{
                animalPossivel = true;
            }
        }
    }

    public void apagaParty(){
        for (int i = 0; i<3; i++){
            animais[i] = null;
        }
    }
}
