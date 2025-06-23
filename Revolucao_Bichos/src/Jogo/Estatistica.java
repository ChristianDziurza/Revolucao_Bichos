package Jogo;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

import static java.lang.System.in;

public class Estatistica {
    int torneiosVencidos, dinTotal, itensComprados, inimAbatidos, animaisComprados, maiorTorneioAlcancado, totalMortes, animaisMorto;
    public Estatistica(){
        inimAbatidos= 0;
        totalMortes = 0;
        animaisMorto = 0;
    }
    public void addEstMortes(int x){
        totalMortes += x;
    }

    public int getTotalMortes() {
        return totalMortes;
    }

    public int getAnimaisMorto() {
        return animaisMorto;
    }

    public void setAnimaisMorto(int animaisMorto) {
        this.animaisMorto += animaisMorto;
    }

    public int addDinTotal(int x){
        dinTotal += x;
        return x;
    }
    public int addTorneiosVencidos(int x){
        torneiosVencidos += x;
        return x;
    }
    public int addItensComprados(int x){
        itensComprados += x;
        return x;
    }
    public void addInimAbatidos(int x){
        inimAbatidos += x;
    }
    public int getInimAbatidos(){
        return inimAbatidos;
    }
    public int addAnimaisComprados(int x){
        animaisComprados += x;
        return x;
    }
    public int setMaiorTorneioAlcancado(int x){
        if (x<maiorTorneioAlcancado){
            maiorTorneioAlcancado = x;
        }
        return x;
    }
    public void Update() throws IOException {
        BufferedWriter writer = null;
        int i = 0;
        String g ="";
        try{
            BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
            while ((g=br.readLine())!= null){
                g = g.replaceAll("\\D", "");
                if(i == 0) {
                    totalMortes += Integer.parseInt(g);
                }
                if(i == 1){
                    inimAbatidos += Integer.parseInt(g);
                }
                if(i == 2){
                    animaisMorto += Integer.parseInt(g);
                }
                i++;
            }
            writer = new BufferedWriter(new FileWriter("dados.txt"));
            writer.write("Total de mortes: " + totalMortes + "\n");
            writer.write("Total de inimigos abatidos: " + inimAbatidos + "\n");
            writer.write("Total de aliados abatidos: " + animaisMorto + "\n");

            totalMortes = 0;
            animaisMorto = 0;
            inimAbatidos = 0;
            writer.newLine();

        }catch(IIOException e){
            System.out.println("Erro");
        }finally {
            try{
                if(writer != null)
                    writer.close();
            }catch (IIOException e){
                System.out.println("Fechando arquivo");
            }
        }
    }
    public void Escreve(){
        BufferedWriter writer = null;
        int i = 0;
        String g ="";
        try {
            BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
            System.out.println("Suas estatísticas até agora!!!!!");
            while ((g = br.readLine()) != null) {
                System.out.println(g);
            }
            System.out.println("Gostaria de apagar os dados? (S ou N)");
            String escolha;
            Scanner scanner = new Scanner(System.in);
            escolha = scanner.nextLine();
            if(escolha.equals("S")|| escolha.equals("s")){
                writer = new BufferedWriter(new FileWriter("dados.txt"));
                while ((g = br.readLine()) != null) {
                    writer.write(" ");
                }
            }
        }catch(IIOException e){
            System.out.println("Erro");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
