package ru.aleons.reportcard.dao.query.select;

import ru.aleons.reportcard.dao.implementation.GroupDaoImpl;
import ru.aleons.reportcard.model.Groups;

import java.sql.SQLException;
import java.util.List;

public class GroupsSelect {
    public Groups getGroups(int idGroups) throws SQLException {
        GroupDaoImpl groupDao = new GroupDaoImpl();
        return groupDao.getGroup(idGroups);
    }

    public List<Groups> getAllGroups() throws SQLException {
        GroupDaoImpl groupDao = new GroupDaoImpl();
        return groupDao.getGroups();
    }
}
