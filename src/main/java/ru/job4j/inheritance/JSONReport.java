package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        return "{" + ln
                + "\t\"name\" : \"" + name + "\"," + ln
                + "\t\"body\" : \"" + body + "\"" + ln + "}";
    }

    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("Names", "Body");
        System.out.println(text);
    }
}