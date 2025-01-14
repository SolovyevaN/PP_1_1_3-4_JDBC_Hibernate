package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser(new User(1L, "Petya", "Ivanov", (byte) 20));
        System.out.println("User с именем Petya добавлен в базу.");
        userDao.saveUser(new User(2L, "Zina", "Petrova", (byte) 25));
        System.out.println("User с именем Zina добавлен в базу.");
        userDao.saveUser(new User(3l, "Kolya", "Pupkin", (byte) 31));
        System.out.println("User с именем Kolya добавлен в базу.");
        userDao.saveUser(new User(4L, "Max", "Sidorov", (byte) 38));
        System.out.println("User с именем Max добавлен в базу.");

        userDao.removeUserById(1);
        System.out.println("User с ID = 1 удален из базы.");

        System.out.println("Список всех пользователей в базе:");
        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }

        userDao.cleanUsersTable();
        System.out.println("Таблица пользователей очищена.");

        userDao.dropUsersTable();
        System.out.println("Таблица пользователей удалена.");
    }
}
