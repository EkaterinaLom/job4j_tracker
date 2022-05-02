package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String workingTool;

    public Surgeon(String namef, String surn, String educ, String birthd, String workTool) {
        super(namef, surn, educ, birthd, workTool);
        this.workingTool = workTool;
    }

    public String favoriteTool() {
        return workingTool;
    }

    public static void main(String[] args) {
        Surgeon olga = new Surgeon("Olga", "Popova", "hight", "17.02.80", "scalpel");
        System.out.println(olga.getName());
        System.out.println(olga.getSurname());
        System.out.println(olga.getEducation());
        System.out.println(olga.getBirthday());
        System.out.println(olga.favoriteTool());
    }
}
