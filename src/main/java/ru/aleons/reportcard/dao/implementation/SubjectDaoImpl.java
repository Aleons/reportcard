package ru.aleons.reportcard.dao.implementation;

import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.SubjectDao;
import ru.aleons.reportcard.dao.query.add.SubjectAdd;
import ru.aleons.reportcard.dao.query.delete.SubjectDelete;
import ru.aleons.reportcard.dao.query.select.PulpitSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.SubjectUpdate;
import ru.aleons.reportcard.model.Subject;
import ru.aleons.reportcard.model.signature.SubjectS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public void addSubject(Subject subject) throws SQLException {
        String query = " insert into subject(name, time, users)"
                + " values (?, ?, ?)";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,subject.getName());
            preparedStatement.setInt(2, subject.getTime());
            preparedStatement.setString(3,subject.getUsers().getLogin());
            preparedStatement.execute();
            SubjectAdd.FLAG_ADD_SUBJECT=true;
        }
        catch (Exception e){
            SubjectAdd.FLAG_ADD_SUBJECT= false;
            SubjectAdd.TEXT_ERROR = e.toString();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void delSubject(int idSubject) throws SQLException {
        String query ="DELETE FROM subject WHERE id ='"+idSubject+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            SubjectDelete.FLAG_DELETE_SUBJECT=true;
        }
        catch (Exception e){
            System.out.println(e);
            SubjectDelete.FLAG_DELETE_SUBJECT=false;
            SubjectDelete.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }

    @Override
    public void updateSubject(SubjectS subjectS) throws SQLException {
        String query ="UPDATE subject SET name = '"+subjectS.getName()+"',  time = '"+subjectS.getTime()+"', users = '"+subjectS.getUsers().getLogin()+"' WHERE id = '"+subjectS.getId()+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            SubjectUpdate.FLAG_UPDATE_SUBJECT = true;
        }
        catch (Exception e){
            System.out.println(e);
            SubjectUpdate.FLAG_UPDATE_SUBJECT =  false;
            SubjectUpdate.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public Subject getSubject(int idSUbject) throws SQLException {
            String query ="SELECT * FROM subject WHERE id ='"+idSUbject+"'";
            Connect connect = new Connect();
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            Subject subject = null;
            UsersSelect usersSelect = null;
            PulpitSelect pulpitSelect = null;
            try{
                connection = connect.getConnect();
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
                resultSet.next();
                subject = new Subject();
                usersSelect = new UsersSelect();
                pulpitSelect = new PulpitSelect();
                subject.setName(resultSet.getString("name"));
                String usr = new String(resultSet.getString("users"));
                subject.setUsers(usersSelect.getUsers(usr));
                subject.setTime(resultSet.getInt("time"));
                subject.setId(resultSet.getInt("id"));
            }
            catch (Exception e){

                //логирование
            }

            finally {
                resultSet.close();
                statement.close();
                connection.close();
            }

            return subject;

    }

    @Override
    public List<Subject> getAllSubjects() throws SQLException {
        String query ="SELECT * FROM subject";
        List<Subject> listSubject= new ArrayList<Subject>();
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Subject subject = null;
        UsersSelect usersSelect = null;
        PulpitSelect pulpitSelect = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
            subject = new Subject();
            usersSelect = new UsersSelect();
            pulpitSelect = new PulpitSelect();
            subject.setName(resultSet.getString("name"));
            String usr = new String(resultSet.getString("users"));
            subject.setUsers(usersSelect.getUsers(usr));
            subject.setId(resultSet.getInt("id"));
            subject.setTime(resultSet.getInt("time"));
            listSubject.add(subject);

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


        return listSubject;
    }
}
