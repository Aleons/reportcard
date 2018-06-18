package ru.aleons.reportcard.dao.query.update;

import ru.aleons.reportcard.dao.implementation.StudDaoImpl;
import ru.aleons.reportcard.dao.interfaces.StudDao;
import ru.aleons.reportcard.model.signature.StudS;

import java.sql.SQLException;

public class StudUpdate {
    public static boolean FLAG_UPDATE_STUD = true;
    public static String TEXT_ERROR ="";
    public void studUpdate(StudS studS) throws SQLException {
        StudDao studDao = new StudDaoImpl();
        studDao.updateStud(studS);
    }
}
