package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String areaProgram;

    public Programmer(String namef, String surn, String educ, String birthd, String areaPr) {
        super(namef, surn, educ, birthd, areaPr);
        this.areaProgram = areaPr;
    }

    public String sectionProgr() {
        return areaProgram;
    }

    public static void main(String[] args) {
        Programmer rich = new Programmer("Rich", "Tompson", "hight", "13.04.54", "game development");
        System.out.println(rich.getName());
        System.out.println(rich.getSurname());
        System.out.println(rich.getEducation());
        System.out.println(rich.getBirthday());
        System.out.println(rich.sectionProgr());
    }
}
