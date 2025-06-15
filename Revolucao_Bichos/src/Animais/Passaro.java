package Animais;

public class Passaro extends Animal{
    @Override
    public void IniciaTurno() {
    }

    @Override
    public void LevaDano(int x) {

        setVida(vida-x);
        if(vida <= 0){
            Morte();
        }
    }


    @Override
    public void Especial(){

    }
}
