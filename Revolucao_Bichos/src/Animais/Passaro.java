package Animais;

import Itens.Consumivel;
import Itens.ItemDefesa;

public class Passaro extends Animal{
    @Override
    public void IniciaTurno() {
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
        System.out.println("Não");
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

        if (!(inim.getDano().intValue()<=1)) {
            inim.setDano(inim.getDano().intValue() - 1);
        }
    }
}
