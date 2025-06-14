package Animais;

public class Passaro extends Animal{
    @Override
    public void IniciaTurno() {

    }

    @Override
    public void LevaDano(int x) {

        setVida(vida-x);
        System.out.println("Vida atual: " + vida);
        if(vida <= 0){
            Morte();
        }
    }

    @Override
    public void Morte() {
        morto=true;
        System.out.println("Esta morto: ");
    }

    @Override
    public void Especial(){

    }
}
