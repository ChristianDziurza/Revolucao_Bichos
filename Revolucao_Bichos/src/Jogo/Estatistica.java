package Jogo;

import javax.imageio.IIOException;
import java.io.*;

import static java.lang.System.in;

public class Estatistica {
    int torneiosVencidos, dinTotal, itensComprados, inimAbatidos, animaisComprados, maiorTorneioAlcancado, totalMortes;
    public Estatistica(){
        inimAbatidos= 0;
    }
    public int addEstMortes(int x){
        totalMortes += x;
        return x;
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
        String g ="";
        try{
            writer = new BufferedWriter(new FileWriter("dados.txt"));
            BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
            while ((g=br.readLine())!= null){
                g = g.replaceAll("\\D", "");
                inimAbatidos += Integer.parseInt(g);
            }
            writer.write("Inimigos mortos: " + inimAbatidos);
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

}
