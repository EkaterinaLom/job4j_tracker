package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int lenght = Math.min(first.length, second.length);
        for (int i = 0; i < lenght; i++) {
            if (first[0].equals(second[0])) {
                rsl = o1.compareTo(o2);
            } else {
                rsl = second[0].compareTo(first[0]);
            }
        }
        return rsl;
    }
}
