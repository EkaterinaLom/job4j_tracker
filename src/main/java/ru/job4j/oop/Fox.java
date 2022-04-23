package ru.job4j.oop;

public class Fox {
    public void tryRun(boolean condition) {
        boolean rsl = true;
        if (rsl == condition) {
            System.out.println("Колобок съеден");
        } else {
            System.out.println("Колобок сбежал");
        }
    }

    public void tryEat(Ball ball) {
        this.tryRun(true);
    }
}
