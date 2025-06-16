package Animais;

public class Passaro extends Animal{
    @Override
    public void IniciaTurno() {
        System.out.println("Não");
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

        if (!(inim.getDano().intValue()<=1)) {
            inim.setDano(inim.getDano().intValue() - 1);
        }
    }
}
