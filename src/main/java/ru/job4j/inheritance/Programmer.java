package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String areaProgram = "game development";

    public Programmer(String namef, String surn, String educ, String birthd) {
        super(namef, surn, educ, birthd);
    }

    public Programmer(String areaPr) {
        super();
        this.areaProgram = areaPr;
    }

    public Programmer() {
    }

    public String sectionProgr() {
        return areaProgram;
    }

    public static void main(String[] args) {
        Programmer rich = new Programmer("Rich", "Tompson", "hight", "13.04.54");
        System.out.println(rich.getName());
        System.out.println(rich.getSurname());
        System.out.println(rich.getEducation());
        System.out.println(rich.getBirthday());
        System.out.println(rich.sectionProgr());
    }
}
