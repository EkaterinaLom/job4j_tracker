package ru.job4j.poly;

public class PolyTransport {
    public static void main(String[] args) {
        Vehicle air = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new BusBus();

        Vehicle[] vehicles = new Vehicle[]{air, train, bus};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}