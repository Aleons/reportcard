package ru.aleons.reportcard.dao.interfaces;

import ru.aleons.reportcard.model.Tabel;
import ru.aleons.reportcard.model.signature.TabelS;

import java.sql.SQLException;
import java.util.List;

public interface TabelDao {
    public void addTabel (Tabel tabel) throws SQLException;
    public void delTabel (int idStud,  int idLabs) throws SQLException;
    public void updateTabel (TabelS tabelS) throws SQLException;
    public  Tabel getTabel (int idStud,  int idLabs) throws SQLException;
    public List<Tabel> getTabels() throws SQLException;
}
