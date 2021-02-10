package main.java;

public class Server {
    private String status;
    private int age;

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
        this.age = age;
        if(age < 18) {
            this.status = "student";
        } else if (age < 60) {
            this.status = "worker";
        } else {
            this.status = "pensioner";
        }
    }
}
