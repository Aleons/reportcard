package ru.aleons.reportcard.dao.interfaces;

import ru.aleons.reportcard.model.Stud;
import ru.aleons.reportcard.model.signature.StudS;

import java.sql.SQLException;
import java.util.List;

public interface StudDao {
    public void addStud (Stud stud) throws SQLException;
    public void delStud (int idStud) throws SQLException;
    public void updateStud (StudS studS) throws SQLException;
    public  Stud getStud (int idStud) throws SQLException;
    public List<Stud> getStud() throws SQLException;
}
