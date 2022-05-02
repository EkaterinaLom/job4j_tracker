package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String profile;

    public Doctor(String namef, String surn, String educ, String birthd, String prof) {
        super(namef, surn, educ, birthd);
        this.profile = prof;
    }

    public String profileDoc() {
        return profile;
    }

    public static void main(String[] args) {
        Doctor egor = new Doctor("Egor", "Petrov", "higher", "12.08.77", "stomatologist");
        System.out.println(egor.getName());
        System.out.println(egor.getSurname());
        System.out.println(egor.getEducation());
        System.out.println(egor.getBirthday());
        System.out.println(egor.profileDoc());
    }
}
