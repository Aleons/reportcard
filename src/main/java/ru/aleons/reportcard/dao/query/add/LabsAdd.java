package ru.aleons.reportcard.dao.query.add;

import ru.aleons.reportcard.dao.implementation.LabsDaoImpl;
import ru.aleons.reportcard.dao.interfaces.LabsDao;
import ru.aleons.reportcard.model.Labs;
import ru.aleons.reportcard.model.Subject;

import java.sql.SQLException;

public class LabsAdd {
    public static boolean FLAG_ADD_Labs = true;
    public static String TEXT_ERROR ="";
    public void addLabs(int idSubject, int numberLr,  String description) throws SQLException {
        Subject subject = new Subject();
        subject.setId(idSubject);
        Labs labs = new Labs(numberLr,description,subject);
        LabsDao labsDao= new LabsDaoImpl();
        labsDao.addLabs(labs);
    }
}
