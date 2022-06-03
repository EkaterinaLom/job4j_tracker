package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key == value[i]) {
                rsl = i;
            } else {
                throw new ElementNotFoundException("There is no such element in the array");
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"Value"}, "check");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
