package ru.aleons.reportcard.dao.interfaces;



import ru.aleons.reportcard.model.Pulpit;
import ru.aleons.reportcard.model.signature.PulpitS;


import java.sql.SQLException;
import java.util.List;

public interface PulpitDao {
    public void addPulpit (Pulpit pulpit) throws SQLException;
    public void delPulpit (int numberPulpit) throws SQLException;
    public void updatePulpit (PulpitS pulpit) throws SQLException;
    public  Pulpit getPulpit (int numberPulpit) throws SQLException;
    public List<Pulpit> getPulpits() throws SQLException;
}
