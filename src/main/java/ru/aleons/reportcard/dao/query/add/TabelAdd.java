package ru.aleons.reportcard.dao.query.add;

import ru.aleons.reportcard.dao.implementation.TabelDaoImpl;
import ru.aleons.reportcard.dao.interfaces.TabelDao;
import ru.aleons.reportcard.model.Labs;
import ru.aleons.reportcard.model.Stud;
import ru.aleons.reportcard.model.Tabel;

import java.sql.SQLException;

public class TabelAdd {
    public static boolean FLAG_ADD_TABEL = true;
    public static String TEXT_ERROR ="";
    public void addTabel(Labs idLabs, Stud idStud, String date, int point) throws SQLException {
        Stud stud = new Stud(idStud.getId());
        Labs labs = new Labs(idLabs.getId());
        Tabel tabel = new Tabel(idStud, idLabs, point, date);
        TabelDao tabelDao = new TabelDaoImpl();
        tabelDao.addTabel(tabel);
    }
}
