package ru.aleons.reportcard.dao.query.delete;

import ru.aleons.reportcard.dao.implementation.UsersDaoImpl;

import java.sql.SQLException;

public class UsersDelete {
    public static boolean FLAG_DELETE_USERS = true;
    public static String TEXT_ERROR ="";
    public void deleteUsers(String login) throws SQLException {
        UsersDaoImpl  pulpitDao = new UsersDaoImpl();
        pulpitDao.delUsers(login);

    }
}
