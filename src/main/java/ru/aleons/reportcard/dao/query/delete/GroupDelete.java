package ru.aleons.reportcard.dao.query.delete;
import ru.aleons.reportcard.dao.implementation.GroupDaoImpl;
import ru.aleons.reportcard.dao.interfaces.GroupDao;

import java.sql.SQLException;

public class GroupDelete {
    public static boolean FLAG_DELETE_GROUP = true;
    public static String TEXT_ERROR ="";
    public void deleteGroup(int idGroup) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        groupDao.delGroup(idGroup);
    }
}
