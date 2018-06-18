package ru.aleons.reportcard.dao.query.delete;

import ru.aleons.reportcard.dao.implementation.TabelDaoImpl;
import ru.aleons.reportcard.dao.interfaces.TabelDao;

import java.sql.SQLException;

public class TabelDelete {
    public static boolean FLAG_DELETE_TABEL = true;
    public static String TEXT_ERROR ="";
    public void deleteTable(int idLabs, int idSud) throws SQLException {
        TabelDao tabelDao = new TabelDaoImpl();
        tabelDao.delTabel(idSud,idLabs);
    }
}
