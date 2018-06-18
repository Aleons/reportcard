package ru.aleons.reportcard.dao.query.update;

import ru.aleons.reportcard.dao.implementation.TabelDaoImpl;
import ru.aleons.reportcard.dao.interfaces.TabelDao;
import ru.aleons.reportcard.model.signature.TabelS;

import java.sql.SQLException;

public class TabelUpdate {
    public static boolean FLAG_UPDATE_TABEL = true;
    public static String TEXT_ERROR ="";
    public void tableUpdate(TabelS tabelS) throws SQLException {
        TabelDao tabelDao = new TabelDaoImpl();
        tabelDao.updateTabel(tabelS);
    }
}
