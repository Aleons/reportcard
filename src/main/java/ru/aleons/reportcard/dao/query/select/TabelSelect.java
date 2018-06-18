package ru.aleons.reportcard.dao.query.select;

import ru.aleons.reportcard.dao.implementation.TabelDaoImpl;
import ru.aleons.reportcard.dao.interfaces.TabelDao;
import ru.aleons.reportcard.model.Tabel;

import java.sql.SQLException;
import java.util.List;

public class TabelSelect {
    public Tabel getTabel(int idStud, int idLabs) throws SQLException {
        TabelDao tabelDao = new TabelDaoImpl();
        return tabelDao.getTabel(idStud,idLabs);
    }

    public List<Tabel> getAllTabel() throws SQLException {
        TabelDao tabelDao = new TabelDaoImpl();
        return tabelDao.getTabels();
    }
}
