package ru.aleons.reportcard.dao.query.add;



import ru.aleons.reportcard.dao.implementation.PulpitDaoImpl;
import ru.aleons.reportcard.model.Pulpit;

import java.sql.SQLException;

public class PulpitAdd {
    public static boolean FLAG_ADD_PULPIT = true;
    public static String TEXT_ERROR ="";
    public void addPulpit(int numberPulpit, String namePulpit) throws SQLException {
        Pulpit pulpit = new Pulpit(numberPulpit, namePulpit);
        PulpitDaoImpl pulpitDao = new PulpitDaoImpl();
        pulpitDao.addPulpit(pulpit);

    }
}
