package ru.aleons.reportcard.dao.implementation;

import ru.aleons.reportcard.config.HashMD5;
import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.SuperUserDao;
import ru.aleons.reportcard.model.SuperUser;
import ru.aleons.reportcard.model.hash.SuperUserHash;
import ru.aleons.reportcard.model.signature.SuperUserS;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SuperUserDaoImpl implements SuperUserDao {
    @Override
    public void addSuperUser(SuperUser pulpit) throws SQLException {

    }

    @Override
    public void delSuperUser(String login) throws SQLException {

    }

    @Override
    public void updateSuperUser(SuperUserS superUser) throws SQLException {

    }

    @Override
    public String getSuperUserHash(String hash) throws SQLException, NoSuchAlgorithmException {
        HashMD5 hashMD5 = new HashMD5();
        String query ="SELECT * FROM superuser WHERE hash ='"+hash+"'";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String getHash = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            getHash = (resultSet.getString("hash"));

        }
        catch (Exception e){

            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return getHash;
    }

    @Override
    public SuperUser getSuperUser(String login) throws SQLException {
        return null;
    }

    @Override
    public List<SuperUser> getSuperUsers() throws SQLException {
        return null;
    }
}
