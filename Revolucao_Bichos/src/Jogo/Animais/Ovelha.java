package Jogo.Animais;

import Jogo.Exceptions.MorteException;
import Jogo.Itens.TipoItem;

public class Ovelha extends Animal{

    @Override
    public void IniciaTurno(Animal[] animal, Animal pos){
        iniciaVida();
        int i=0, j=0;
        for(Animal an: animal){
            if(an == pos){
                j = i;
            }
            i++;
        }
        if(j<2){
            try {
                animal[j+1].addConsumivel(TipoItem.C_COCO.criaItem());
            }catch (NullPointerException e){

            }
        }
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

    }
}
