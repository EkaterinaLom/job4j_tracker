package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item first = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateTime = first.getCreated().format(formatter);
        System.out.println(dateTime);
        Item second = new Item(12, "Second");
        System.out.println("Item: " + second.getName() + " "
        + second.getId() + " "
        + second.getCreated().format(formatter)
        );
    }
}
