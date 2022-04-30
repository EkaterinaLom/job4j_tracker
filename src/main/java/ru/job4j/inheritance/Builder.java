package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String wageSys = "price-work";

    public Builder(String namef, String surn, String educ, String birthd) {
        super(namef, surn, educ, birthd);
    }

    public Builder(String wageS) {
        super();
        this.wageSys = wageS;
    }

    public Builder() {
    }

    public String priceWork() {
        return wageSys;
    }

    public static void main(String[] args) {
        Builder kate = new Builder("Kate", "Holms", "secondary", "05.06.87");
        System.out.println(kate.getName());
        System.out.println(kate.getSurname());
        System.out.println(kate.getEducation());
        System.out.println(kate.getBirthday());
        System.out.println(kate.priceWork());
    }
}
