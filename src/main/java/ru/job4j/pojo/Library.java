package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book first = new Book("Clean code", 125);
        Book second = new Book("Wor and peace", 534);
        Book third = new Book("Peak Lady", 375);
        Book fourth = new Book("Gulliver adventures", 250);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPage());
        }
        System.out.println("Traded places");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPage());
        }
        System.out.println("Shown only book.name \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getPage());
            }
        }
    }
}