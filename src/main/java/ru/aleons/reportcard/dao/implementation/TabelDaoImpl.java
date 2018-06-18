package ru.aleons.reportcard.dao.implementation;

import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.TabelDao;
import ru.aleons.reportcard.dao.query.add.TabelAdd;
import ru.aleons.reportcard.dao.query.delete.TabelDelete;
import ru.aleons.reportcard.dao.query.select.LabsSelect;
import ru.aleons.reportcard.dao.query.select.StudSelect;
import ru.aleons.reportcard.dao.query.update.TabelUpdate;
import ru.aleons.reportcard.model.Tabel;
import ru.aleons.reportcard.model.signature.TabelS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TabelDaoImpl implements TabelDao {
    @Override
    public void addTabel(Tabel tabel) throws SQLException {
        String query = " insert into tabel(id_stud, id_labs, points, dates)"
                + " values (?, ?, ?, ?)";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,tabel.getIdStud().getId());
            preparedStatement.setInt(2,tabel.getIdLabs().getId());
            preparedStatement.setInt(3,tabel.getPoint());
            preparedStatement.setString(4,tabel.getDate());
            preparedStatement.execute();
            TabelAdd.FLAG_ADD_TABEL = true;
        }
        catch (Exception e){
            TabelAdd.FLAG_ADD_TABEL = false;
            TabelAdd.TEXT_ERROR = e.toString();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void delTabel(int idStud, int idLabs) throws SQLException {
        String query ="DELETE FROM tabel WHERE id_labs ='"+idLabs+"' AND  id_stud = '"+idStud+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            TabelDelete.FLAG_DELETE_TABEL= true;
        }
        catch (Exception e){
            System.out.println(e);
            TabelDelete.FLAG_DELETE_TABEL= false;
            TabelDelete.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void updateTabel(TabelS tabelS) throws SQLException {
        String query ="UPDATE tabel SET id_labs = '"+tabelS.getIdLabs().getId()+"',  id_stud = '"+tabelS.getIdStud().getId()+"', dates=' "+tabelS.getDate()+"', points=' "+tabelS.getPoint()+"' WHERE id_labs ='"+tabelS.getOldIdLabs().getId()+"' AND  id_stud = '"+tabelS.getOldIdStud().getId()+"'";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            TabelUpdate.FLAG_UPDATE_TABEL = true;
        }
        catch (Exception e){
            System.out.println(e);
            TabelUpdate.FLAG_UPDATE_TABEL = false;
            TabelUpdate.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }


    }

    @Override
    public Tabel getTabel(int idStud, int idLabs) throws SQLException {
        String query ="SELECT * FROM tabel WHERE id_labs='"+idLabs+"' AND  id_stud ='"+idStud+"'";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Tabel tabel = null;
        LabsSelect labsSelect = null;
        StudSelect studSelect = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            tabel = new Tabel();
            studSelect = new StudSelect();
            labsSelect = new LabsSelect();
            tabel.setPoint(resultSet.getInt("points"));
            tabel.setDate(resultSet.getString("dates"));
            Integer idSt = new Integer(resultSet.getInt("id_stud"));
            Integer idL = new Integer(resultSet.getInt("id_labs"));
            tabel.setIdStud(studSelect.getStud(idSt));
            tabel.setIdLabs(labsSelect.getLabs(idL));
        }
        catch (Exception e){

            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return tabel;
    }

    @Override
    public List<Tabel> getTabels() throws SQLException {
        List<Tabel> listTabel= new ArrayList<Tabel>();
        String query ="SELECT * FROM tabel";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Tabel tabel = null;
        LabsSelect labsSelect = null;
        StudSelect studSelect = null;
        try {
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                tabel = new Tabel();
                studSelect = new StudSelect();
                labsSelect = new LabsSelect();
                tabel.setPoint(resultSet.getInt("points"));
                tabel.setDate(resultSet.getString("dates"));
                Integer idSt = new Integer(resultSet.getInt("id_stud"));
                Integer idL = new Integer(resultSet.getInt("id_labs"));
                tabel.setIdStud(studSelect.getStud(idSt));
                tabel.setIdLabs(labsSelect.getLabs(idL));
                listTabel.add(tabel);
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


        return listTabel;
    }
}
