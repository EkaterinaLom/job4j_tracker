package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void whenCompare() {
        List<Item> items = Arrays.asList(new Item(1, "Anna"), new Item(3, "Ivan"),
                new Item(4,  "Tom"), new Item(2,  "Eva"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item(4, "Tom"), new Item(3, "Ivan"),
                new Item(2, "Eva"), new Item(1, "Anna"));
        assertEquals(expected, items);

    }
}