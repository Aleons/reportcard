package ru.aleons.reportcard.dao.query.update;

import ru.aleons.reportcard.dao.implementation.PulpitDaoImpl;
import ru.aleons.reportcard.model.signature.PulpitS;


import java.sql.SQLException;

public class PulpitUpdate {
    public static boolean FLAG_UPDATE_PULPIT = true;
    public static String TEXT_ERROR ="";
    public void pulpitUpdate(PulpitS pulpit) throws SQLException {
        PulpitDaoImpl pulpitDao = new PulpitDaoImpl();
        pulpitDao.updatePulpit(pulpit);
    }
}
