package ru.aleons.reportcard.dao.query.delete;

import ru.aleons.reportcard.dao.implementation.StudDaoImpl;
import ru.aleons.reportcard.dao.interfaces.StudDao;

import java.sql.SQLException;

public class StudDelete {
    public static boolean FLAG_DELETE_STUD = true;
    public static String TEXT_ERROR ="";
    public void deleteStud(int idStud) throws SQLException {
        StudDao studDao = new StudDaoImpl();
        studDao.delStud(idStud);
    }
}
