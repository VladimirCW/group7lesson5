package main.java;

public class Server {
    private String status;
    private int age = 10;

    public Server() {
        this.validateAge(this.age);
    }

    private void validateAge(int age) {
        if(age < 18) {
            this.status = "student";
        } else if (age < 60) {
            this.status = "worker";
        } else {
            this.status = "pensioner";
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age <= 100) this.age = age;
        this.validateAge(this.age);
    }
}
