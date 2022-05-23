package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void trip() {
        System.out.println("Trip");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Trip passengers: " + passengers);
    }

    @Override
    public double refill(double fuel) {
        int cost = 50;
        double rsl = cost * fuel;
        return rsl;
    }
}