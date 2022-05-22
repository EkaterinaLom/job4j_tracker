package ru.job4j.poly;

public interface Transport {

    void trip();

    void passengers(int passengers);

    double refill(double fuel);
}
