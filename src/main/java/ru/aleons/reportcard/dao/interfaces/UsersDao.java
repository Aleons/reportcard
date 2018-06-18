package ru.aleons.reportcard.dao.interfaces;

import ru.aleons.reportcard.model.Users;
import ru.aleons.reportcard.model.signature.UsersS;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public interface UsersDao {
    public void addUsers (Users users) throws SQLException;
    public void delUsers (String login) throws SQLException;
    public void updateUsers (UsersS usersS) throws SQLException, NoSuchAlgorithmException;
    public  Users getUsers (String login) throws SQLException;
    public List<Users> getUsers() throws SQLException;
    public String geUserHash (String hash) throws SQLException, NoSuchAlgorithmException;
}
