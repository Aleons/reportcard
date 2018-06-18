package ru.aleons.reportcard.dao.interfaces;

import ru.aleons.reportcard.model.Groups;
import ru.aleons.reportcard.model.signature.GroupsS;

import java.sql.SQLException;
import java.util.List;

public interface GroupDao {
    public void addGroup (Groups groups) throws SQLException;
    public void delGroup (int idGroup) throws SQLException;
    public void updateGroup (GroupsS groupsS) throws SQLException;
    public  Groups getGroup (int idGroup) throws SQLException;
    public List<Groups> getGroups() throws SQLException;
}
