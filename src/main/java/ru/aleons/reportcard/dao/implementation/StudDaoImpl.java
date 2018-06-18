package ru.aleons.reportcard.dao.implementation;

import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.StudDao;
import ru.aleons.reportcard.dao.query.add.StudAdd;
import ru.aleons.reportcard.dao.query.delete.StudDelete;
import ru.aleons.reportcard.dao.query.select.GroupsSelect;
import ru.aleons.reportcard.dao.query.update.StudUpdate;
import ru.aleons.reportcard.model.Stud;
import ru.aleons.reportcard.model.signature.StudS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudDaoImpl implements StudDao {
    @Override
    public void addStud(Stud stud) throws SQLException {
        String query = " insert into stud(fio, id_groups, contact)"
                + " values (?, ?, ?)";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,stud.getFio());
            preparedStatement.setInt(2,stud.getIdGroups().getId());
            preparedStatement.setString(3, stud.getContact());

            preparedStatement.execute();
            StudAdd.FLAG_ADD_STUD = true;
        }
        catch (Exception e){
            StudAdd.FLAG_ADD_STUD = false;
            StudAdd.TEXT_ERROR = e.toString();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }

    @Override
    public void delStud(int idStud) throws SQLException {
        String query ="DELETE FROM stud WHERE id ='"+idStud+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            StudDelete.FLAG_DELETE_STUD = true;
        }
        catch (Exception e){
            System.out.println(e);
            StudDelete.FLAG_DELETE_STUD = false;
            StudDelete.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void updateStud(StudS studS) throws SQLException {
        String query ="UPDATE stud SET fio = '"+studS.getFio()+"',  id_groups = '"+studS.getIdGroups().getId()+"',contact=' "+studS.getContact()+"' WHERE id = '"+studS.getId()+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            StudUpdate.FLAG_UPDATE_STUD = true;
        }
        catch (Exception e){
            System.out.println(e);
            StudUpdate.FLAG_UPDATE_STUD = false;
            StudUpdate.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public Stud getStud(int idStud) throws SQLException {
        String query ="SELECT * FROM stud WHERE id ='"+idStud+"'";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Stud stud = null;
        GroupsSelect groupsSelect = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            stud =new Stud();
            groupsSelect = new GroupsSelect();
            stud.setFio(resultSet.getString("fio"));
            stud.setContact(resultSet.getString("contact"));
            stud.setId(resultSet.getInt("id"));
            Integer ng = new Integer(resultSet.getInt("id_groups"));
            stud.setIdGroups(groupsSelect.getGroups(ng));
        }
        catch (Exception e){

            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return stud;
    }

    @Override
    public List<Stud> getStud() throws SQLException {
        List<Stud> listStud= new ArrayList<Stud>();
        String query ="SELECT * FROM stud";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Stud stud = null;
        GroupsSelect groupsSelect = null;
        try {
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                stud =new Stud();
                groupsSelect = new GroupsSelect();
                stud.setFio(resultSet.getString("fio"));
                stud.setContact(resultSet.getString("contact"));
                stud.setId(resultSet.getInt("id"));
                Integer ng = new Integer(resultSet.getInt("id_groups"));
                stud.setIdGroups(groupsSelect.getGroups(ng));
                listStud.add(stud);

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


        return listStud;
    }
}
