package main.java.Inheritance;

public class Programm {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        ImmortalPonny ponny = new ImmortalPonny();
        ImmortalPonny ponny2 = new ImmortalPonny();

        Atackable animals[] = {new Cat(), new Dog()};
        Atackable dog2 = new Dog();

        long a = new Integer(10);

        dog.fight(cat);
        //ponny.fight(ponny2);
        ponny.fight(dog);
        //cat.fight(ponny);


    }
}
