package ru.aleons.reportcard.dao.interfaces;

import ru.aleons.reportcard.model.Labs;
import ru.aleons.reportcard.model.signature.LabsS;

import java.sql.SQLException;
import java.util.List;

public interface LabsDao {
    public void addLabs(Labs labs) throws SQLException;
    public void delLabs (int idLabs) throws SQLException;
    public void updateLabs (LabsS labsS) throws SQLException;
    public  Labs getLabs (int idLabs) throws SQLException;
    public List<Labs> getLabs() throws SQLException;
}
