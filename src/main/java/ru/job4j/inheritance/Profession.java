package ru.job4j.inheritance;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String namef, String surn, String educ, String birthd) {
        this.name = namef;
        this.surname = surn;
        this.education = educ;
        this.birthday = birthd;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }
}