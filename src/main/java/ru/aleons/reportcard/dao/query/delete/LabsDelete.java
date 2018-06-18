package ru.aleons.reportcard.dao.query.delete;

import ru.aleons.reportcard.dao.implementation.LabsDaoImpl;
import ru.aleons.reportcard.dao.interfaces.LabsDao;

import java.sql.SQLException;

public class LabsDelete {
    public static boolean FLAG_DELETE_SUBJECT = true;
    public static String TEXT_ERROR ="";
    public void deleteLabs(int idLabs) throws SQLException {
        LabsDao labsDao =new LabsDaoImpl();
        labsDao.delLabs(idLabs);
    }
}
