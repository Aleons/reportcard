package ru.aleons.reportcard.dao.query.select;

import ru.aleons.reportcard.dao.implementation.SuperUserDaoImpl;
import ru.aleons.reportcard.model.hash.SuperUserHash;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class SuperUserSelect {
    public String getSuperUserHash(String signature) throws SQLException, NoSuchAlgorithmException {
        SuperUserDaoImpl superUserDao = new SuperUserDaoImpl();
        return superUserDao.getSuperUserHash(signature);


    }
}
