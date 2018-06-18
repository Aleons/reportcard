package ru.aleons.reportcard.dao.implementation;

import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.LabsDao;
import ru.aleons.reportcard.dao.query.add.LabsAdd;
import ru.aleons.reportcard.dao.query.delete.LabsDelete;
import ru.aleons.reportcard.dao.query.select.SubjectSelect;
import ru.aleons.reportcard.dao.query.update.LabsUpdate;
import ru.aleons.reportcard.model.Labs;
import ru.aleons.reportcard.model.signature.LabsS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LabsDaoImpl implements LabsDao {
    @Override
    public void addLabs(Labs labs) throws SQLException {
        String query = " insert into labs(id_subject, number_lr, description)"
                + " values (?, ?, ?)";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,labs.getIdSubject().getId());
            preparedStatement.setInt(2,labs.getNumberLr());
            preparedStatement.setString(3, labs.getDescription());

            preparedStatement.execute();
            LabsAdd.FLAG_ADD_Labs = true;
        }
        catch (Exception e){
            LabsAdd.FLAG_ADD_Labs = false;
            LabsAdd.TEXT_ERROR = e.toString();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void delLabs(int idLabs) throws SQLException {
        String query ="DELETE FROM labs WHERE id ='"+idLabs+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            LabsDelete.FLAG_DELETE_SUBJECT = true;
        }
        catch (Exception e){
            System.out.println(e);
            LabsDelete.FLAG_DELETE_SUBJECT = false;
            LabsDelete.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }

    @Override
    public void updateLabs(LabsS labsS) throws SQLException {
        String query ="UPDATE labs SET id_subject = '"+labsS.getIdSubject().getId()+"',  number_lr = '"+labsS.getNumberLr()+"',description=' "+labsS.getDescription()+"' WHERE id = '"+labsS.getId()+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            LabsUpdate.FLAG_UPDATE_SUBJECT = true;
        }
        catch (Exception e){
            System.out.println(e);
            LabsUpdate.FLAG_UPDATE_SUBJECT = false;
            LabsUpdate.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }

    @Override
    public Labs getLabs(int idLabs) throws SQLException {
        String query ="SELECT * FROM labs WHERE id ='"+idLabs+"'";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Labs labs = null;
        SubjectSelect subjectSelect = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            labs = new Labs();
            subjectSelect = new SubjectSelect();
            Integer idSuject = new Integer(resultSet.getInt("id_subject"));
            labs.setNumberLr(resultSet.getInt("number_lr"));
            labs.setDescription(resultSet.getString("description"));
            labs.setId(resultSet.getInt("id"));
            labs.setIdSubject(subjectSelect.getSubject(idSuject));
        }
        catch (Exception e){

            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return labs;
    }

    @Override
    public List<Labs> getLabs() throws SQLException {
        List<Labs> listLabs= new ArrayList<Labs>();
        String query ="SELECT * FROM labs";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Labs labs= null;
        SubjectSelect subjectSelect = null;
        try {
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                labs = new Labs();
                subjectSelect = new SubjectSelect();
                Integer idSuject = new Integer(resultSet.getInt("id_subject"));
                labs.setNumberLr(resultSet.getInt("number_lr"));
                labs.setDescription(resultSet.getString("description"));
                labs.setIdSubject(subjectSelect.getSubject(idSuject));
                labs.setId(resultSet.getInt("id"));
                listLabs.add(labs);

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


        return listLabs;
    }
}
