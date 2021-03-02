package main.java.Inheritance;

public class Dog extends Animal implements Atackable {

    public void bark() {
        System.out.println("Gav-gav");
    }

    @Override
    void fight(Atackable animal) {
        System.out.println("Fighting");
    }

    @Override
    public void move() {
        System.out.println("Go - go");
    }

    @Override
    public void onAttack() {
        System.out.println("Attacked");
    }
}
