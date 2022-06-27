package ru.job4j.search;

public class Task {
    private String desc;
    private int prioryity;

    public Task(String desc, int prioryity) {
        this.desc = desc;
        this.prioryity = prioryity;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrioryity() {
        return prioryity;
    }
}