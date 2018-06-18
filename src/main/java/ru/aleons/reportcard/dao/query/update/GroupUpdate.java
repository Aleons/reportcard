package ru.aleons.reportcard.dao.query.update;
import ru.aleons.reportcard.dao.implementation.GroupDaoImpl;
import ru.aleons.reportcard.dao.interfaces.GroupDao;
import ru.aleons.reportcard.model.signature.GroupsS;
import java.sql.SQLException;
public class GroupUpdate {
    public static boolean FLAG_UPDATE_GROUP = true;
    public static String TEXT_ERROR ="";
    public void groupUpdate(GroupsS groupsS) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        groupDao.updateGroup(groupsS);
    }
}
