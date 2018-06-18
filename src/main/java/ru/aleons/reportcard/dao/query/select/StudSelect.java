package ru.aleons.reportcard.dao.query.select;

import ru.aleons.reportcard.dao.implementation.StudDaoImpl;
import ru.aleons.reportcard.model.Stud;

import java.sql.SQLException;
import java.util.List;

public class StudSelect {
    public Stud getStud(int idStud) throws SQLException {
        StudDaoImpl studDao = new StudDaoImpl();
        return studDao.getStud(idStud);
    }

    public List<Stud> getAllStud() throws SQLException {
        StudDaoImpl studDao = new StudDaoImpl();
        return studDao.getStud();
    }
}
