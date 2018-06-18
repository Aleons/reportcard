package ru.aleons.reportcard.dao.implementation;

import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.GroupDao;
import ru.aleons.reportcard.dao.query.add.GroupAdd;
import ru.aleons.reportcard.dao.query.delete.GroupDelete;
import ru.aleons.reportcard.dao.query.select.PulpitSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.GroupUpdate;
import ru.aleons.reportcard.model.Groups;
import ru.aleons.reportcard.model.Users;
import ru.aleons.reportcard.model.signature.GroupsS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {
    @Override
    public void addGroup(Groups groups) throws SQLException {
        String query = " insert into groups(groups, users, number_pulpit)"
                + " values (?, ?, ?)";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,groups.getNameGroups());
            preparedStatement.setString(2, groups.getuser().getLogin());
            preparedStatement.setInt(3,groups.getNumberPulpit().getNumberPulpit());
            preparedStatement.execute();
            GroupAdd.FLAG_ADD_GROUP = true;
        }
        catch (Exception e){
            GroupAdd.FLAG_ADD_GROUP = false;
            GroupAdd.TEXT_ERROR = e.toString();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }

    @Override
    public void delGroup(int idGroup) throws SQLException {
        String query ="DELETE FROM groups WHERE id ='"+idGroup+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            GroupDelete.FLAG_DELETE_GROUP = true;
        }
        catch (Exception e){
            System.out.println(e);
            GroupDelete.FLAG_DELETE_GROUP = false;
            GroupDelete.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void updateGroup(GroupsS groupsS) throws SQLException {
        String query ="UPDATE groups SET groups = '"+groupsS.getNameGroups()+"',  users = '"+groupsS.getUsers().getLogin()+"',number_pulpit=' "+groupsS.getNumberPulpit().getNumberPulpit()+"' WHERE id = '"+groupsS.getId()+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            GroupUpdate.FLAG_UPDATE_GROUP = true;
        }
        catch (Exception e){
            System.out.println(e);
            GroupUpdate.FLAG_UPDATE_GROUP = false;
            GroupUpdate.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public Groups getGroup(int idGroup) throws SQLException {
        String query ="SELECT * FROM groups WHERE id ='"+idGroup+"'";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Groups groups = null;
        UsersSelect usersSelect = null;
        PulpitSelect pulpitSelect = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            groups = new Groups();
            usersSelect = new UsersSelect();
            pulpitSelect = new PulpitSelect();
            groups.setNameGroups(resultSet.getString("groups"));
            String usr = new String(resultSet.getString("users"));
            Integer n_p = new Integer(resultSet.getInt("number_pulpit"));
            groups.setNumberPulpit(pulpitSelect.getPulpit(n_p));
            groups.setuser(usersSelect.getUsers(usr));
            groups.setId(resultSet.getInt("id"));
        }
        catch (Exception e){

            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return groups;
    }

    @Override
    public List<Groups> getGroups() throws SQLException {
        List<Groups> listGroups= new ArrayList<Groups>();
        String query ="SELECT * FROM groups";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Groups groups = null;
        UsersSelect usersSelect = null;
        PulpitSelect pulpitSelect = null;
        try {
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                groups = new Groups();
                usersSelect = new UsersSelect();
                pulpitSelect = new PulpitSelect();
                groups.setNameGroups(resultSet.getString("groups"));
                String usr = new String(resultSet.getString("users"));
                Integer n_p = new Integer(resultSet.getInt("number_pulpit"));
                groups.setNumberPulpit(pulpitSelect.getPulpit(n_p));
                groups.setuser(usersSelect.getUsers(usr));
                groups.setId(resultSet.getInt("id"));
                listGroups.add(groups);

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


        return listGroups;
    }
}
