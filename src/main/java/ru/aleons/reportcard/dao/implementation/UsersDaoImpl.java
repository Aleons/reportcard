package ru.aleons.reportcard.dao.implementation;

import ru.aleons.reportcard.config.HashMD5;
import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.UsersDao;
import ru.aleons.reportcard.dao.query.add.UsersAdd;
import ru.aleons.reportcard.dao.query.delete.UsersDelete;
import ru.aleons.reportcard.model.Users;
import ru.aleons.reportcard.model.signature.UsersS;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    @Override
    public void addUsers(Users users) throws SQLException {
        String query = " insert into users(login, pass, fio, academic_degree, number_pulpit, hash)"
                + " values (?, ?, ?, ?, ?, ?)";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        HashMD5 hashMD5 = new HashMD5();
        try{
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,users.getLogin());
            preparedStatement.setString(2,users.getPass());
            preparedStatement.setString(3,users.getFio());
            preparedStatement.setString(4, users.getAcademicDegree());
            preparedStatement.setInt(5, users.getNumberPulpit());
            preparedStatement.setString(6, hashMD5.toHash(users.getLogin()+users.getPass()));
            preparedStatement.execute();
            UsersAdd.FLAG_ADD_USERS = true;
        }
        catch (Exception e){
            UsersAdd.FLAG_ADD_USERS = false;
            UsersAdd.TEXT_ERROR = e.toString();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }


    }

    @Override
    public void delUsers(String login) throws SQLException {
        String query ="DELETE FROM users WHERE login ='"+login+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            UsersDelete.FLAG_DELETE_USERS = true;
        }
        catch (Exception e){
            System.out.println(e);
            UsersDelete.FLAG_DELETE_USERS = false;
            UsersDelete.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void updateUsers(UsersS usersS) throws SQLException, NoSuchAlgorithmException {
        HashMD5 hashMD5 = new HashMD5();
        String hash = hashMD5.toHash(usersS.getLogin()+usersS.getPass());
        String query ="UPDATE users SET login = '"+usersS.getLogin()+"',  pass = '"+usersS.getPass()+"', fio = '"+usersS.getFio()+"', academic_degree = '"+usersS.getAcademicDegree()+"', number_pulpit = '"+usersS.getNumberPulpit()+"', hash = '"+hash+"'  WHERE login = '"+usersS.getOldLogin()+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e);


        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public Users getUsers(String login) throws SQLException {
        String query ="SELECT * FROM users WHERE login ='"+login+"'";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Users users = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            users = new Users();
            users.setLogin(resultSet.getString("login"));
            users.setPass("***");
            users.setFio(resultSet.getString("fio"));
            users.setAcademicDegree(resultSet.getString("academic_degree"));
            users.setNumberPulpit(resultSet.getInt("number_pulpit"));
        }
        catch (Exception e){

            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return users;
    }

    @Override
    public List<Users> getUsers() throws SQLException {
        List<Users> listUsers= new ArrayList<Users>();
        String query ="SELECT * FROM users";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Users users = null;
        try {
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                users = new Users();
                users.setLogin(resultSet.getString("login"));
                users.setPass("***");
                users.setFio(resultSet.getString("fio"));
                users.setAcademicDegree(resultSet.getString("academic_degree"));
                users.setNumberPulpit(resultSet.getInt("number_pulpit"));
                listUsers.add(users);

            }
        }
        catch (Exception e){
            System.out.println(e);
            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
        return listUsers;
    }

    @Override
    public String geUserHash(String hash) throws SQLException, NoSuchAlgorithmException {
        HashMD5 hashMD5 = new HashMD5();
        String query ="SELECT * FROM users WHERE hash ='"+hash+"'";
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
}
