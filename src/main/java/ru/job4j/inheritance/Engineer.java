package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String experience;

    public Engineer(String namef, String surn, String educ, String birthd, String exper) {
        super(namef, surn, educ, birthd);
        this.experience = exper;
    }

    public String getExperience() {
        return experience;
    }

    public static void main(String[] args) {
        Engineer tom = new Engineer("Tom", "Hanson", "higher", "22.03.70", "12");
        System.out.println(tom.getName());
        System.out.println(tom.getSurname());
        System.out.println(tom.getEducation());
        System.out.println(tom.getBirthday());
        System.out.println(tom.getExperience());
    }
}
