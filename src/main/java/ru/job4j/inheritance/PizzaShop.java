package ru.job4j.inheritance;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza(" pizza");
        PizzaExtraCheese pizzaExtraCheese = new PizzaExtraCheese(" pizza");
        PizzaExtraCheesaExtraTomato pizzaExtraCheeseExtraTomato = new PizzaExtraCheesaExtraTomato(" pizza");
        System.out.println(pizza.name());
        System.out.println(pizzaExtraCheese.name());
        System.out.println(pizzaExtraCheeseExtraTomato.name());
    }
}