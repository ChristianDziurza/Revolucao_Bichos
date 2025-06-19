package Animais;

import Exceptions.MorteException;

public class Peixe extends Animal{
    @Override
    public void IniciaTurno(Animal inim) {
        iniciaVida();
        if (!(inim.getDano().intValue()<=1)) {
            inim.setDano(inim.getDano().intValue() - 1);
        }
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

    }
}
