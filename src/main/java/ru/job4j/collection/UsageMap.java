package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Lomakinaei@mail.ru", "Lomakina EI");
        map.put("Lomakinaei@mail.ru", "Lomakina Katya");
        map.put("Ivanov@mail.ru", "Ivanov Ivan");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
