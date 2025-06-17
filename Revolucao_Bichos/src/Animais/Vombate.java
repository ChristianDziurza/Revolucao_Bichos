package Animais;

import Itens.Consumivel;
import Itens.ItemDefesa;

public class Vombate extends Animal{
    @Override
    public void IniciaTurno() {
        int overhealthtotal = 0;
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
        setVida(getVida()-x/2);

    }



    @Override
    public void Especial(Animal inim){
        inim.LevaDano(inim.Ataque().intValue()/2);
    }
}
