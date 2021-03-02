package main.java.Inheritance;

public class Cat extends Animal implements Atackable{
    @Override
    void fight(Atackable animal) {
        System.out.println("Fighting");
    }

    @Override
    void move() {

    }

    @Override
    public void onAttack() {
        System.out.println("Attacked");
    }
}
