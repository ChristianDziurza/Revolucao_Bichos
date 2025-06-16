package Animais;

public class Vombate extends Animal{
    @Override
    public void IniciaTurno() {
        System.out.println("Não");
    }

    @Override
    public void LevaDano(int x) {
        setVida(getVida()-x/2);

    }



    @Override
    public void Especial(Animal inim){
        inim.setVida(inim.getVida()-(inim.Ataque().intValue()/2));
    }
}
