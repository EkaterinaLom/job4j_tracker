package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка.
 */
public class User {
    /**
     * Поле характеризует данные паспорта пользователя.
     */
    private String passport;
    /**
     * поле характеризует имя пользователя.
     */
    private String username;

    /**
     * Конструктор описывет пользователя системы который будет принимать 2 параметра
     * и записывать их в соответствующие поля.
     * @param passport входящие паспортные данные.
     * @param username имя пользователя на входе.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод - геттер, возвращает значение паспортных данных.
     * @return возвращает значение паспортных данных
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод - сеттер, при необходимости дает возможность изменить данные паспорта.
     * @param passport принимает значение паспортных данных.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод - геттер, возвращает значение имя пользователя.
     * @return возвращает значение имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер, обеспечивает доступ к изменению имени пользователя.
     * @param username на входе принимает значение имени пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение equals, для корректного сравнения объектов.
     * @param o принимает на входе объект
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение hashCode, для корректного сравнения объектов
     * @return возвращает число, которому равен входящий объект.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
