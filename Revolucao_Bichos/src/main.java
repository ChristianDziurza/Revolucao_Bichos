import Animais.*;

import java.util.*;

public class main {
    public static void main(String[] args) {
        //na real, acho que precisa, pq cada animal vai ter stat diferente, ou a gente faz
        //os sets deles iniciarem com valores específicos, mas acho que fica meio feio
        //até mais
        Animal[] animaisP = criaArray();
        Animal[] animaisI = criaArray();
        System.out.println("Animais A:");
        for(Animal animal : animaisP){
            System.out.println(animal.getClass());
        }
        System.out.println("Animais B:");
        for(Animal animal : animaisI){
            System.out.println(animal.getClass());
        }
    }
    public static Animal[] criaArray(){
        Animal[] animasi = new Animal[3];
        TiposAnimais[] tipo = TiposAnimais.values();
        for(int i = 0; i<3; i++){
            Random rand = new Random();
            animasi[i] = tipo[rand.nextInt(tipo.length)].criaAnimal();
        }
        return animasi;
    }
}
