package main.java.Inheritance;

public abstract class Animal {

    abstract void fight(Atackable animal);

    abstract void move();

    public void eat() {
        System.out.println("nyam-nyam");
    }
}
