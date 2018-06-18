package ru.aleons.reportcard.dao.query.select;

import ru.aleons.reportcard.dao.implementation.SubjectDaoImpl;
import ru.aleons.reportcard.dao.interfaces.SubjectDao;
import ru.aleons.reportcard.model.Stud;
import ru.aleons.reportcard.model.Subject;

import java.sql.SQLException;
import java.util.List;

public class SubjectSelect {
    public Subject getSubject(int idSubject) throws SQLException {
        SubjectDao subjectDao = new SubjectDaoImpl();
        return subjectDao.getSubject(idSubject);
    }

    public List<Subject> getAllSubjects() throws SQLException {
        SubjectDao subjectDao = new SubjectDaoImpl();
        return subjectDao.getAllSubjects();
    }
}
