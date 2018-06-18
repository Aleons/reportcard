package ru.aleons.reportcard.dao.query.delete;

import ru.aleons.reportcard.dao.implementation.SubjectDaoImpl;
import ru.aleons.reportcard.dao.interfaces.SubjectDao;

import java.sql.SQLException;

public class SubjectDelete {
    public static boolean FLAG_DELETE_SUBJECT = true;
    public static String TEXT_ERROR ="";
    public void deleteSubject(int idSubject) throws SQLException {
        SubjectDao subjectDao = new SubjectDaoImpl();
        subjectDao.delSubject(idSubject);
    }
}
