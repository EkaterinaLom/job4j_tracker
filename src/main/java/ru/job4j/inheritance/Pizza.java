package ru.job4j.inheritance;

public class Pizza {

    private String struct;

    public Pizza(String struct) {
        this.struct = struct;
    }

    public String name() {
        return "Just tasty" + struct;
    }
}
