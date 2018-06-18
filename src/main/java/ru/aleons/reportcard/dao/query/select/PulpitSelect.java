package ru.aleons.reportcard.dao.query.select;



import ru.aleons.reportcard.dao.implementation.PulpitDaoImpl;
import ru.aleons.reportcard.model.Pulpit;

import java.sql.SQLException;
import java.util.List;

public class PulpitSelect {
    public Pulpit getPulpit(int numberPulpit) throws SQLException {
        PulpitDaoImpl pulpitDao = new PulpitDaoImpl();
        return pulpitDao.getPulpit(numberPulpit);
    }

    public List<Pulpit> getAllPulpit() throws SQLException {
        PulpitDaoImpl pulpitDao = new PulpitDaoImpl();
        return pulpitDao.getPulpits();
    }


}
