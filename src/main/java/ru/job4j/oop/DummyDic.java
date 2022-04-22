package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String phrase = "Неизвестное слово";
        return phrase + " " + eng;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String answer = dic.engToRus("unknown");
        System.out.println(answer);
    }
}
