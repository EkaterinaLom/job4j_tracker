package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String workingTool = "scalpel";

    public Surgeon(String namef, String surn, String educ, String birthd) {
        super(namef, surn, educ, birthd);
    }

    public Surgeon(String workTool) {
        super();
        this.workingTool = workTool;
    }

    public Surgeon() {
    }

    public String favoriteTool() {
        return workingTool;
    }

    public static void main(String[] args) {
        Surgeon olga = new Surgeon("Olga", "Popova", "hight", "17.02.80");
        System.out.println(olga.getName());
        System.out.println(olga.getSurname());
        System.out.println(olga.getEducation());
        System.out.println(olga.getBirthday());
        System.out.println(olga.favoriteTool());
    }
}
