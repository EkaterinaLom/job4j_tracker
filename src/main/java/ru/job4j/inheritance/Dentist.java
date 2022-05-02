package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String goodDent;

    public Dentist(String namef, String surn, String educ, String birthd, String goodD) {
        super(namef, surn, educ, birthd, goodD);
        this.goodDent = goodD;
    }

    public String patientFeedbak() {
        return goodDent;
    }

    public static void main(String[] args) {
        Dentist vika = new Dentist("Vika", "Kravec", "hight", "18.03.89", "Cупер - стоматолог");
        System.out.println(vika.getName());
        System.out.println(vika.getSurname());
        System.out.println(vika.getEducation());
        System.out.println(vika.getBirthday());
        System.out.println(vika.patientFeedbak());
    }
}
