package ru.aleons.reportcard.dao.query.update;

import ru.aleons.reportcard.dao.implementation.SubjectDaoImpl;
import ru.aleons.reportcard.dao.interfaces.SubjectDao;
import ru.aleons.reportcard.model.signature.SubjectS;

import java.sql.SQLException;

public class SubjectUpdate {
    public static boolean FLAG_UPDATE_SUBJECT = true;
    public static String TEXT_ERROR ="";
    public void subjectUpdate(SubjectS subjectS) throws SQLException {
        SubjectDao subjectDao = new SubjectDaoImpl();
        subjectDao.updateSubject(subjectS);
    }
}
