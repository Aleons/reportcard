package ru.aleons.reportcard.dao.interfaces;

import ru.aleons.reportcard.model.Subject;
import ru.aleons.reportcard.model.signature.SubjectS;

import java.sql.SQLException;
import java.util.List;

public interface SubjectDao {
    public void addSubject (Subject subject) throws SQLException;
    public void delSubject (int idSubject) throws SQLException;
    public void updateSubject (SubjectS subjectS) throws SQLException;
    public  Subject getSubject (int idSUbject) throws SQLException;
    public List<Subject> getAllSubjects() throws SQLException;
}
