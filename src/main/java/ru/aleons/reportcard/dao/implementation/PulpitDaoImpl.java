package ru.aleons.reportcard.dao.implementation;


import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.PulpitDao;
import ru.aleons.reportcard.dao.query.add.PulpitAdd;
import ru.aleons.reportcard.dao.query.delete.PulpitDelete;
import ru.aleons.reportcard.dao.query.update.PulpitUpdate;
import ru.aleons.reportcard.model.Pulpit;
import ru.aleons.reportcard.model.signature.PulpitS;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PulpitDaoImpl implements PulpitDao {
    public void addPulpit(Pulpit pulpit) throws SQLException {
        String query = " insert into pulpit(number_pulpit, name)"
                + " values (?, ?)";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,pulpit.getNumberPulpit());
            preparedStatement.setString(2,pulpit.getName());
            preparedStatement.execute();
            PulpitAdd.FLAG_ADD_PULPIT = true;
        }
        catch (Exception e){
            PulpitAdd.FLAG_ADD_PULPIT = false;
            PulpitAdd.TEXT_ERROR = e.toString();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    public void delPulpit(int numberPulpit) throws SQLException {
        String query ="DELETE FROM pulpit WHERE number_pulpit ='"+numberPulpit+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            PulpitDelete.FLAG_DELETE_PULPIT = true;
        }
        catch (Exception e){
            System.out.println(e);
            PulpitDelete.FLAG_DELETE_PULPIT = false;
            PulpitDelete.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }



    public void updatePulpit(PulpitS pulpit) throws SQLException {
        String query ="UPDATE pulpit SET number_pulpit = '"+pulpit.getNumberPulpit()+"',  name = '"+pulpit.getName()+"' WHERE number_pulpit = '"+pulpit.getOldNumberPulpit()+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            PulpitUpdate.FLAG_UPDATE_PULPIT = true;
        }
        catch (Exception e){
            System.out.println(e);
            PulpitUpdate.FLAG_UPDATE_PULPIT = false;
            PulpitUpdate.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }


    }

    public Pulpit getPulpit(int numberPulpit) throws SQLException {
        String query ="SELECT * FROM pulpit WHERE number_pulpit ='"+numberPulpit+"'";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Pulpit pulpit = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            pulpit = new Pulpit();
            pulpit.setNumberPulpit(resultSet.getInt("number_pulpit"));
            pulpit.setName(resultSet.getString("name"));

        }
        catch (Exception e){

            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return pulpit;
    }

    public List<Pulpit> getPulpits() throws SQLException {
        List<Pulpit> listPulpit= new ArrayList<Pulpit>();
        String query ="SELECT * FROM pulpit";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Pulpit pulpit = null;
        try {
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                pulpit = new Pulpit();
                pulpit.setNumberPulpit(resultSet.getInt("number_pulpit"));
                pulpit.setName(resultSet.getString("name"));
                listPulpit.add(pulpit);

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


        return listPulpit;
    }
}
