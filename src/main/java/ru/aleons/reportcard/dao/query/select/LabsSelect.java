package ru.aleons.reportcard.dao.query.select;

import ru.aleons.reportcard.dao.implementation.LabsDaoImpl;
import ru.aleons.reportcard.dao.interfaces.LabsDao;
import ru.aleons.reportcard.model.Labs;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class LabsSelect {
    public Labs getLabs(int idLabs) throws SQLException {
        LabsDao labsDao = new LabsDaoImpl();
        return labsDao.getLabs(idLabs);
    }

    public List<Labs> getAllLabs() throws SQLException {
        LabsDao labsDao = new LabsDaoImpl();
        return labsDao.getLabs();
    }


}
