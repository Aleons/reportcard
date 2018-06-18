package ru.aleons.reportcard.dao.query.add;

import ru.aleons.reportcard.dao.implementation.GroupDaoImpl;
import ru.aleons.reportcard.dao.implementation.SubjectDaoImpl;
import ru.aleons.reportcard.dao.interfaces.SubjectDao;
import ru.aleons.reportcard.model.Subject;
import ru.aleons.reportcard.model.Users;

import java.sql.SQLException;

public class SubjectAdd {
    public static boolean FLAG_ADD_SUBJECT = true;
    public static String TEXT_ERROR ="";
    public void addSubject(String name, int time, String user) throws SQLException {

        Users users = new Users();
        users.setLogin(user);
        Subject subject = new Subject(name, time, users);
        SubjectDao subjectDao = new SubjectDaoImpl();
        subjectDao.addSubject(subject);

    }
}
