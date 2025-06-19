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
