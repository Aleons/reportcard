package ru.aleons.reportcard.dao.interfaces;

import ru.aleons.reportcard.model.SuperUser;
import ru.aleons.reportcard.model.hash.SuperUserHash;
import ru.aleons.reportcard.model.signature.SuperUserS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public interface SuperUserDao {
        public void addSuperUser (SuperUser pulpit) throws SQLException;
        public void delSuperUser (String login) throws SQLException;
        public void updateSuperUser (SuperUserS superUser) throws SQLException;
        public String getSuperUserHash (String hash) throws SQLException, NoSuchAlgorithmException;
        public  SuperUser getSuperUser (String login) throws SQLException;
        public List<SuperUser> getSuperUsers() throws SQLException;

}
