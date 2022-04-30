package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int experience = 12;

    public Engineer(String namef, String surn, String educ, String birthd) {
        super(namef, surn, educ, birthd);
    }

    public Engineer(int exper) {
        super();
        this.experience = exper;
    }

    public Engineer() {
    }

    public int getExperience() {
        return experience;
    }

    public static void main(String[] args) {
        Engineer tom = new Engineer("Tom", "Hanson", "higher", "22.03.70");
        System.out.println(tom.getName());
        System.out.println(tom.getSurname());
        System.out.println(tom.getEducation());
        System.out.println(tom.getBirthday());
        System.out.println(tom.getExperience());
    }
}
