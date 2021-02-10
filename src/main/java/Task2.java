package main.java;

public class Task2 {

    public String someMethod() {
        String name = "Vladimir";
        String result = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                result += name + " ";
            }
            result += "\n";
        }
        return  result;
    }
}
