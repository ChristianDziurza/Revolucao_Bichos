package Jogo;

public class Ui {
    public static void menuUi(){
        System.out.println("\t\t\t\tRevolução dos");
        System.out.println("\t\t\t\t\tBichos!");
        System.out.println();
        System.out.println("\t\t\t\t  1.Jogar");
        System.out.println("\t\t\t\t  2.Estátisticas");
        System.out.println("\t\t\t\t  3.Sair");
    }
    public static void opcoesLoja(){
        System.out.println("O que você vai fazer?");
        System.out.print("A - Comprar Animal\t\t");
        System.out.println("I - Comprar Item");
        System.out.print("S - Vender animal\t\t");
        System.out.println("R - Para atualizar a loja");
        System.out.print("E - Ver equipe\t\t\t");
        System.out.println("P - Ir para o próximo combate");

    }
    public final static void clearConsole()
    {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println("Error clearing the console: " + e.getMessage());
        }
    }
}
