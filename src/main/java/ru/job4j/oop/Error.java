package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 98, "Super");
        Error error2 = new Error(true, 56, "Good");
        Error error3 = new Error(true, 6, "Bad");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}