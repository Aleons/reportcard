package ru.aleons.reportcard.dao.query.add;

import ru.aleons.reportcard.dao.implementation.UsersDaoImpl;
import ru.aleons.reportcard.model.Users;
import ru.aleons.reportcard.model.signature.UsersS;

import java.sql.SQLException;

public class UsersAdd {
    public static boolean FLAG_ADD_USERS = true;
    public static String TEXT_ERROR ="";
    public void addUsers(UsersS userS) throws SQLException {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        Users users = new Users(userS.getLogin(),userS.getPass(),userS.getFio(),userS.getAcademicDegree(),userS.getNumberPulpit());
        usersDao.addUsers(users);
    }
}
