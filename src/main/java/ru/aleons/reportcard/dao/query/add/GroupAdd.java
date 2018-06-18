package ru.aleons.reportcard.dao.query.add;
import ru.aleons.reportcard.dao.implementation.GroupDaoImpl;
import ru.aleons.reportcard.dao.implementation.PulpitDaoImpl;
import ru.aleons.reportcard.model.Groups;
import ru.aleons.reportcard.model.Pulpit;
import ru.aleons.reportcard.model.Users;

import java.sql.SQLException;

public class GroupAdd {
    public static boolean FLAG_ADD_GROUP = true;
    public static String TEXT_ERROR ="";
    public void addGroup(String name, String user, int numberPulpit) throws SQLException {
        Pulpit pulpit = new Pulpit();
        pulpit.setNumberPulpit(numberPulpit);
        Users users = new Users();
        users.setLogin(user);
        Groups groups = new Groups(name, pulpit,users);
        GroupDaoImpl groupDao = new GroupDaoImpl();
        groupDao.addGroup(groups);

    }
}
