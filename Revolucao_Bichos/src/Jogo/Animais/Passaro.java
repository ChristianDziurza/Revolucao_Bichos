package Jogo.Animais;

import Jogo.Exceptions.MorteException;

public class Passaro extends Animal{
    @Override
    public void IniciaTurno() {
        iniciaVida();
    }

    @Override
    public void LevaDano(int x) {//ata
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
    public void Especial(Animal inim){

        if (!(inim.getDano().intValue()<=1)) {
            inim.setDano(inim.getDano().intValue() - 1);
        }
    }
}
