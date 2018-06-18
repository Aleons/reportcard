package ru.aleons.reportcard.dao.query.add;

import ru.aleons.reportcard.dao.implementation.StudDaoImpl;
import ru.aleons.reportcard.model.Groups;
import ru.aleons.reportcard.model.Stud;

import java.sql.SQLException;

public class StudAdd {
    public static boolean FLAG_ADD_STUD = true;
    public static String TEXT_ERROR ="";
    public void addStud(String fio, int idGroups,  String contact) throws SQLException {
        Groups groups = new Groups();
        groups.setId(idGroups);
        Stud stud = new Stud(fio,contact,groups);
        StudDaoImpl studDao = new StudDaoImpl();
        studDao.addStud(stud);
    }
}
