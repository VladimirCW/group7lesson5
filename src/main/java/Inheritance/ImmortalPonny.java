package main.java.Inheritance;

public class ImmortalPonny extends Animal{
    @Override
    void fight(Atackable animal) {
        System.out.println("Fighting");
    }

    @Override
    void move() {
        System.out.println("Moving");
    }
}
