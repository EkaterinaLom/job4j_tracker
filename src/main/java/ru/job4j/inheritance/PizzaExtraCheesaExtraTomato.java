package ru.job4j.inheritance;

public class PizzaExtraCheesaExtraTomato extends PizzaExtraCheese {
    private static final String STRUCT2 = " + extra tomato";

    public PizzaExtraCheesaExtraTomato(String name) {
        super(name);
    }

    @Override
    public String name() {
        return super.name() + STRUCT2;
    }
}
