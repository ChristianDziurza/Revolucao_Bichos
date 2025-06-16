package Animais;

import Itens.TipoItem;

//teste
public class Dinossauro extends Animal{
    @Override
    public void IniciaTurno(Animal[] animal, Animal pos){
        int i=0, j = 0;
        for(Animal an: animal){
            if(an == pos){
                j = i;
            }
            i++;
        }
        if(i<2){
            animal[j+1].addConsumivel(TipoItem.C_BANANA.criaItem());
        }
    }

    @Override
    public void LevaDano(int x) {
        setVida(vida-x);
        if(vida <= 0){
            Morte();
        }
    }



    @Override
    public void Especial(Animal inim){

    }
}
