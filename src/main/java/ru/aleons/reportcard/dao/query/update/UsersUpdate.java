package ru.aleons.reportcard.dao.query.update;

import ru.aleons.reportcard.dao.implementation.UsersDaoImpl;
import ru.aleons.reportcard.model.signature.UsersS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UsersUpdate {
    public void usersUpdate(UsersS usersS) throws SQLException, NoSuchAlgorithmException {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        usersDao.updateUsers(usersS);
    }
}
