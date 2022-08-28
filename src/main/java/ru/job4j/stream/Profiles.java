package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(new AddressComparator())
                .distinct()
                .collect(Collectors.toList());
    }

    public static class AddressComparator implements Comparator<Address> {

        @Override
        public int compare(Address o1, Address o2) {
            return o1.getCity().toUpperCase().compareTo(o2.getCity().toUpperCase());
        }
    }
}
