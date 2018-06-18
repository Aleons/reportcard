package ru.aleons.reportcard.dao.query.update;

import ru.aleons.reportcard.dao.implementation.LabsDaoImpl;
import ru.aleons.reportcard.dao.interfaces.LabsDao;
import ru.aleons.reportcard.model.signature.LabsS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LabsUpdate {
    public static boolean FLAG_UPDATE_SUBJECT = true;
    public static String TEXT_ERROR ="";
    public void labsUpdate(LabsS labsS) throws SQLException, NoSuchAlgorithmException {
        LabsDao labsDao = new LabsDaoImpl();
        labsDao.updateLabs(labsS);
    }
}
