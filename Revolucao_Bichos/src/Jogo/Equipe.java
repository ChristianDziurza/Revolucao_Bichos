package Jogo;
import Animais.*;
import Itens.*;
import java.util.Scanner;

/**
 * Esta classe foi feita com a função de manipular a equipe do jogador
 * @author Gabo K.S.
 * @version 1.0
 */


public class Equipe {
    Animal[] animais = new Animal[3];

    /**
     * Esse método verifica se a equipe está cheia
     * @return o boleano da verificação
     */
    public boolean isFull(){
        boolean isfull = true;
        for(Animal animal : animais){
            if(animal == null){
                isfull = false;
            }
        }
        return isfull;
    }
    /**
     * Esse método verifica se a equipe está vazia
     * @return o boleano da verificação
     */
    public boolean isNull(){
        boolean isNull = true;
        for(Animal animal : animais){
            if(animal != null){
                isNull = false;
            }
        }
        return isNull;
    }

    /**
     * Neste metódo verifica se a equipe tem mais de um membro para trocas
     * ou remoção de membros
     * @return o boleano da equação
     */
    public boolean maisDeUm(){
        boolean temMaisDeUm = true;
        int maxParty = 3;
        for(Animal animal : animais){
            if(animal == null){
                maxParty--;
            }
        }
        if(!(maxParty > 1))
            temMaisDeUm = false;
        return temMaisDeUm;
    }

    /**
     * Esse método foi feito com o principio de adicionar animais a equipe
     * ele utiliza método de verificação se cheio para não ter problemas após
     * e também utiliza recursão
     * @param pos é a posição do vetor
     * @param animal é o animal que seria colocado na posição do vetor
     */
    public void insereParty(int pos, Animal animal){
        Scanner scanner = new Scanner(System.in);
        if(isFull()){
            System.out.println("Party cheia!!!!!\n" + "Não é possível adicionar um animal, gostaria de remover algum?");
            char c = scanner.next().charAt(0);
            if(c == 'S' || c == 's'){
                System.out.println("Insira qual animal quer tirar");
                int pos2 = scanner.nextInt();
                removeParty(pos2);
                insereParty(pos, animal);
            }
        }
        else{
            boolean semExecption = false;
            while (!semExecption) {
                semExecption = true;

                /**
                 * Faz a verificação se foi inserido um numero certo.
                 * @exception ArrayIndexOutOfBoundsException
                 */
                try {
                    animais[pos] = animal;
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("O valor de pos está fora do escopo!!!!\n" + "Insira um novo valor:");

                    pos = scanner.nextInt();
                    semExecption = false;
                }
            }
            System.out.println("Animal inserido com sucesso!!!!");
        }
    }

    /**
     * Esse metodo foi criado com a intençao de alterar a posição dos animais entre si
     * utiliza a verificação de maisDeUm para não ter problemas em trocar com vazio
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
                 * Faz a verificação se foi inserido um numero certo.
                 * @exception ArrayIndexOutOfBoundsException
                 */
                try {
                    aux = animais[pos1];
                    while (!semExecption2) {
                        semExecption2 = true;

                        /**
                         * Faz a verificação se foi inserido um numero certo.
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
            System.out.println("Animais reposicionados");
        }
        else{
            System.out.println("Não tem animais o suficiente");
        }
    }

    /**
     * Aqui esse método é pra tirar animais da equipe
     * utiliza a verifição de maisDeUm para não deixar a equipe vazia
     * é só uma questão de segurança para players não removerem membros e
     * perderem por causa disso
     * @param pos posição do animal que vai ser retirado
     */
    public void removeParty(int pos){
        if(maisDeUm()){
            boolean semExecption = false;
            while (!semExecption){
                semExecption = true;
                /**
                 * Faz a verificação se foi inserido um numero certo.
                 * @exception ArrayIndexOutOfBoundsException
                 */
                try {
                    animais[pos] = null;
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("O valor de pos2 está fora do escopo!!!!\n" + "Insira um novo valor:");
                    Scanner scanner = new Scanner(System.in);
                    pos = scanner.nextInt();
                    semExecption = false;
                }
            }
            System.out.println("Animal deletado");
        }
        else{
            System.out.println("Não tem o suficiente");
        }
    }

    public void insereEquipamento(int pos, Item equipamento){
        boolean semException = false;
        Scanner scanner = new Scanner(System.in);
        while (!semException){
            semException = true;//
            try {
                if((animais[pos] != null)){
                    animais[pos].setEquipamento(equipamento);
                    System.out.println("Inserido com sucesso");
                }
                else{
                    System.out.println("Nao tem animal");
                    semException = false;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Insira um numero adequado");
                pos = scanner.nextInt();
                semException = false;
            }
        }
    }
    public void imprimeEquipe(){

        for(Animal as: animais){
            try{
            System.out.print("Animal: ");
            System.out.println(as.getClass());
            if(as.getEquipamento() != null) {
                System.out.print("Item: ");
                System.out.println(as.getEquipamento());
            }else{//
                System.out.println("Não possui equipamento");
            }
        }catch(NullPointerException e){
                System.out.println("Não tem ninguém");
        }
        }
    }
    public Animal primeiroAnimal(){
        Animal pos;
        int i = 0;
        pos = animais[i];
        if(animais[i].Morte()) {
            i++;
            pos = animais[i];
        }
        return pos;
    }
}
