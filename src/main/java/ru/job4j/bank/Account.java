package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета.
 */
public class Account {
    /**
     * Поле харктеризует реквизиты счета.
     */
    private String requisite;
    /**
     * Поле характеризует баланс счета.
     */
    private double balance;

    /**
     * Конструктор банковского счета который будет принимать 2 параметра
     * и записывать их в наши поля.
     * @param requisite входящие реквизиты.
     * @param balance баланс на входе.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер реквизитов, по запросу вернет значение реквизитов.
     * @return значение реквизитов.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод - сеттер, при неоходимости предоставит доступ к изменению
     * реквизитов.
     * @param requisite принимает значение реквизитов.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод - геттер по запросу вернет значение баланса.
     * @return возращает значение баланса.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер при неоходимости предоставит доступ к изменению баланса.
     * @param balance принимает значение баланса.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение equals, для корректного сравнения объектов.
     * @param o принимает на входе объект.
     * @return возвращает результат сравнения (true/false).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение hashCode, для корректного сравнения объектов
     * коллекции HashMap.
     * @return возвращает число, которому равен входящий объект.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}