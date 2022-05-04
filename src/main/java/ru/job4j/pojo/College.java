package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setInitials(" Ломакина Е.И.");
        student.setGroup(" ЗБУ-1006");
        student.setDateOfreceipt("10.09.2000г.");

        System.out.println("Студент" + student.getInitials() + ", группы" + student.getGroup() + ". Дата поступления: "
                + student.getDateOfreceipt());
    }
}