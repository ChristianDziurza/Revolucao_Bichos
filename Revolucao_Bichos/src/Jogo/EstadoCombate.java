package Jogo;

import Animais.*;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EstadoCombate {
    private boolean ativo = false, mortoAl=true, mortoIn=true;
    int mortecont = 0, morteinimcont = 0;
    String mortes = "Quantidade de aliados mortos: "+mortecont, mortos="Quantidade de inimigos mortos: "+morteinimcont;

    public void iniciaCombate(){
        ativo = true;
    }

    public boolean getAtivo(){
        return ativo;
    }
    public void terminaCombate(){ ativo = false;}

    public void rodada(Equipe eqp, Equipe inim){
        Animal atacante, inimigo;
        atacante = eqp.primeiroAnimal();//já volto
        inimigo = inim.primeiroAnimal();
        if(mortoAl == true){
            System.out.println("Ativando efeitos do aliado "+atacante);
            if(atacante.getClassificacao() == 3){
                atacante.IniciaTurno();
            }else if(atacante.getClassificacao() == 1){
                atacante.IniciaTurno(eqp.getAnimais(), atacante);
            }else{
                atacante.IniciaTurno(inimigo);
            }
            mortoAl = false;
        }
        if(mortoIn == true){
            System.out.println("Ativando efeitos do inimigo "+inimigo);
            if(inimigo.getClassificacao() == 3){
                inimigo.IniciaTurno();
            }else if(inimigo.getClassificacao() == 1){
                inimigo.IniciaTurno(inim.getAnimais(), inimigo);
            }else{
                inimigo.IniciaTurno(inimigo);
            }
            mortoIn = false;
        }
        System.out.println("Combate entre: ");
        System.out.print(atacante);
        System.out.println(" e "+inimigo);
        System.out.println("Vida de "+atacante+" antes da batalha: "+atacante.getVida() + " " + atacante.getOverhealth());
        System.out.println("Vida de "+inimigo+" antes da batalha: "+inimigo.getVida() + " " + inimigo.getOverhealth());


        atacante.Especial(inimigo);
        inimigo.Especial(atacante);
        inimigo.LevaDano((Integer) atacante.Ataque());
        if (inimigo.getVida()<=0){
            inimigo.setMorto(true);
            mortoIn = true;
            System.out.println(inimigo + " morreu");
            morteinimcont++;
            System.out.println(inimigo.isMorto());
        }
        atacante.LevaDano((Integer) inimigo.Ataque());
        if (atacante.getVida()<=0){
            atacante.setMorto(true);
            mortoAl = true;
            System.out.println(atacante + " morreu");
            mortecont++;

        }

        System.out.println("Vida de "+atacante+" após a batalha: "+atacante.getVida() + " " + atacante.getOverhealth());
        System.out.println("Vida de "+inimigo+" após a batalha: "+inimigo.getVida() + " " + inimigo.getOverhealth());

        if (eqp.allMorto()){
            System.out.println("Sua equipe já era :(");
            System.out.println("O combate terminou");
            terminaCombate();
        }
        if (inim.allMorto()){
            System.out.println("Todos os inimigos foram obliterados :)");
            System.out.println("O combate terminou");
            terminaCombate();
        }
    }
    public void gravarMortes(String aliado, String inimigo) throws IOException {
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter("dados.txt",true));
            writer.write(aliado);
            writer.newLine();
            writer.write(inimigo);
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
