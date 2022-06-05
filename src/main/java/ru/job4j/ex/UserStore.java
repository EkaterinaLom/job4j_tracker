package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User us = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                us = user;
                break;
            }
        }
        if (us == null) {
            throw new UserNotFoundException("User not found");
        }
        return us;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User not valid");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true)};
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}