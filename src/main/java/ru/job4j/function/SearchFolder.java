package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        var rsl = new ArrayList<Folder>();
        Predicate<Folder> predicate = (f) -> ((f.getSize() > 100) || (f.getName().contains("bug")));
        for (Folder f : list) {
            if (predicate.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}
