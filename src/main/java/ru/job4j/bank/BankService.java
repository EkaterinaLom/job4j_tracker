package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует модель банковского сервиса.
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним
     * счетами осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя. Если такого пользователя в
     * сервисе нет, то происходит добавление нового пользователя согласно
     * входных данных.
     * @param user пользователь, которого необходимо добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод реализует добавление нового счета пользователю системы.
     * На входе поступают данные паспорта пользователя и номер счета.
     * По данным паспорта ищется соответствующий пользователь в системе.
     * Если пользователь идентифицирован, идет проверка на отсутствие у него данного счета.
     * Если такого счета у пользователя нет, происходит добавление счета пользователю.
     * @param passport данные паспорта пользователя
     * @param account счет, который неоходимо добавить.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accUser = users.get(user);
            if (!accUser.contains(account)) {
                accUser.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по паспорту.
     * На входе поступают данные паспорта пользователя. Затем через цикл идет перебор всех ключей в коллекции
     * и сопоставление на равенство значений с данными по паспорту.
     * @param passport данные паспорта пользователя.
     * @return возвращает пользовтеля, найденного по паспортным данным; либо null если пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод принимает на входе данные паспорта и реквизиты и осуществляет в системе поиск счета,
     * согласно входных данных. Сперва осущ.поиск пользователя по данным паспорта. Если пользователь найден
     * происходит поиск счета по данным входящих реквизитов.
     * @param passport данные паспорта пользователя, чей счет ищем.
     * @param requisite реквизиты счета который ищем.
     * @return возвращает null в случае если счет не найден. Либо возвращает счет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> value = users.get(user);
            for (Account val : value) {
                if (val.getRequisite().equals(requisite)) {
                    return val;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход данные паспорта и реквизиты отправителя, а т.ж.данные паспорта и реквизиты
     * счета получателя денег. Осуществляет поиск пользователя и его счета, затем идентифицируется пользователь -
     * получатель денег и его счет, используя метод findByRequisite. При полной идентификации отправителя, получателя
     * их счетов и наличии необходимой суммы на счете отправителя происходит перевод денег.
     * @param srcPassport данные паспорта отправителя денег.
     * @param srcRequisite реквизиты счета, с которого нужно перевести деньги.
     * @param destPassport данные паспорта получателя денег.
     * @param destRequisite реквизиты счета, на который нужно перевести деньги.
     * @param amount размер перевода.
     * @return false в слечае, если перевод не выполнен. Либо true если перевод прошел успешно.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        Account accDest = findByRequisite(destPassport, destRequisite);
        if (accSrc != null && accSrc.getBalance() >= amount && accDest != null) {
            accSrc.setBalance(accSrc.getBalance() - amount);
            accDest.setBalance(accDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
