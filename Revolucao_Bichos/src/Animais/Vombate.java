package Animais;

public class Vombate extends Animal{
    @Override
    public void IniciaTurno() {

    }

    @Override
    public void LevaDano(int x) {
        setVida(getVida()-x/2);

    }

    @Override
    public void Morte() {

    }

    @Override
    public void Especial(){
        
    }
}
