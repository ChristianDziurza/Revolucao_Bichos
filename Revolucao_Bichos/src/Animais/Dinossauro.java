package Animais;

import Itens.Consumivel;
import Itens.ItemDefesa;
import Itens.TipoItem;

//teste
public class Dinossauro extends Animal{
    @Override
    public void IniciaTurno(Animal[] animal, Animal pos){
        int i=0, j = 0;
        int overhealthtotal = 0;
        vidatotal = vida;
        try {
            if (getEquipamento().getClass() == ItemDefesa.class) {
                overhealthtotal += getEquipamento().Efeito().intValue();
            }
        }catch (NullPointerException e){

        }
        try {
            for (Consumivel consumivel1 : consumivel) {
                if (consumivel1.geItemUso()) {
                    overhealthtotal += consumivel1.Efeito().intsValue()[1];
                }
            }
        }catch(NullPointerException e){
            System.out.println("Não tem consumivel");
        }
        setOverhealth(overhealthtotal);
        for(Animal an: animal){
            if(an == pos){
                j = i;
            }
            i++;
        }
        if(j<2){
            try {
                animal[j+1].addConsumivel(TipoItem.C_BANANA.criaItem());
            }catch (NullPointerException e){

            }
        }
    }

    @Override
    public void LevaDano(int x) {
        if(getOverhealth() > 0){
            int overheal = getOverhealth() - x;
            if(overheal > 0){
                setOverhealth(overheal);
                x=0;
            }else {
                setOverhealth(0);
                x=overheal * -1;
            }
        }

        setVida(vida-x);
        if(vida <= 0){
            Morte();
        }
    }



    @Override
    public void Especial(Animal inim){

    }
}
