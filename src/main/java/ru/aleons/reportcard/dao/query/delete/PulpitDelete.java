package ru.aleons.reportcard.dao.query.delete;

import ru.aleons.reportcard.dao.implementation.PulpitDaoImpl;
import ru.aleons.reportcard.model.Pulpit;

import java.sql.SQLException;

public class PulpitDelete {
    public static boolean FLAG_DELETE_PULPIT = true;
    public static String TEXT_ERROR ="";
    public void deletePulpit(int numberPulpit) throws SQLException {
        PulpitDaoImpl pulpitDao = new PulpitDaoImpl();
        pulpitDao.delPulpit(numberPulpit);

    }
}
