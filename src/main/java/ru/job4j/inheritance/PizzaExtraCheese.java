package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String STRUCT = " + extra cheese";

    public PizzaExtraCheese(String name) {
        super(name);
    }

    @Override
    public String name() {
        return super.name() + STRUCT;
    }
}
