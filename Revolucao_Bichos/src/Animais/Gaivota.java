package Animais;

import Exceptions.MorteException;
import Itens.Consumivel;
import Itens.ItemDefesa;

public class Gaivota extends Animal{
    private int contador=0;
    @Override
    public void IniciaTurno(){
        iniciaVida();
    }

    @Override
    public void LevaDano(int x){
        try{
            x = checaSobreVida(x);
            setVida(vida-x);
            if(vida <= 0){
                throw new MorteException();
            }
        }catch (MorteException e){
            Morte();
        }
    }

    @Override
    public void Especial(Animal inim) {
        contador++;
        if(contador >=2){
            setOverhealth(2);
            contador=0;
        }
    }
}
