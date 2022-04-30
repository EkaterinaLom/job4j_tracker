package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean goodDent = true;

    public Dentist(String namef, String surn, String educ, String birthd) {
        super(namef, surn, educ, birthd);
    }

    public Dentist(boolean goodD) {
        super();
        this.goodDent = goodD;
    }

    public Dentist() {
    }

    public String patientFeedbak(boolean goodDent) {
        return "Cупер - стоматолог";
    }

    public static void main(String[] args) {
        Dentist vika = new Dentist("Vika", "Kravec", "hight", "18.03.89");
        System.out.println(vika.getName());
        System.out.println(vika.getSurname());
        System.out.println(vika.getEducation());
        System.out.println(vika.getBirthday());
        System.out.println(vika.patientFeedbak(true));
    }
}
