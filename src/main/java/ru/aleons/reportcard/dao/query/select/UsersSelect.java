package ru.aleons.reportcard.dao.query.select;

import ru.aleons.reportcard.dao.implementation.UsersDaoImpl;
import ru.aleons.reportcard.model.Users;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersSelect {
    public Users getUsers(String login) throws SQLException {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        return usersDao.getUsers(login);
    }

    public List<Users> getAllUsers() throws SQLException {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        return usersDao.getUsers();
    }

    public String getUserHash(String signature) throws SQLException, NoSuchAlgorithmException {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        return usersDao.geUserHash(signature);


    }
}
