package ru.job4j.ex;

public class Fact {

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N could not be less then 0");
        }
        int rls = 1;
        for (int index = 2; index <= n; index++) {
            rls *= index;
        }
        return rls;
    }

    public static void main(String[] args) {
        new Fact().calc(-1);
    }
}