package main.java.Inheritance;

public interface Atackable {
    void onAttack();

    default void onMessage() {
        System.out.println("assfsadsadasd");
    }
}
