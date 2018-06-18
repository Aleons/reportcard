package ru.aleons.reportcard.dao.implementation;

import ru.aleons.reportcard.dao.connect.Connect;
import ru.aleons.reportcard.dao.interfaces.AttendanceDao;
import ru.aleons.reportcard.dao.query.add.AttendanceAdd;
import ru.aleons.reportcard.dao.query.delete.AttendanceDelete;
import ru.aleons.reportcard.dao.query.select.StudSelect;
import ru.aleons.reportcard.dao.query.select.SubjectSelect;
import ru.aleons.reportcard.dao.query.update.AttendanceUpdate;
import ru.aleons.reportcard.model.Attendance;
import ru.aleons.reportcard.model.signature.AttendanceS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDaoImpl implements AttendanceDao {
    @Override
    public void addAttendance(Attendance attendance) throws SQLException {
        String query = " insert into attendance(id_stud, id_subject, date_attendance, fact_of_presence)"
                + " values (?, ?, ?, ?)";
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,attendance.getIdStud().getId());
            preparedStatement.setInt(2,attendance.getIdSubject().getId());
            preparedStatement.setString(3, attendance.getDate());
            preparedStatement.setBoolean(4,attendance.getFactOfPresence());
            preparedStatement.execute();
            AttendanceAdd.FLAG_ADD_ATTENDANCE = true;
        }
        catch (Exception e){
            AttendanceAdd.FLAG_ADD_ATTENDANCE = false;
            AttendanceAdd.TEXT_ERROR = e.toString();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }


    }

    @Override
    public void delAttendance(int idStud, int idSubject) throws SQLException {
        String query ="DELETE FROM attendance WHERE id_subject ='"+idSubject+"'AND  id_stud = '"+idStud;
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            AttendanceDelete.FLAG_DELETE_ATTENDANCE = true;
        }
        catch (Exception e){
            System.out.println(e);
            AttendanceDelete.FLAG_DELETE_ATTENDANCE = false;
            AttendanceDelete.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public void updateAttendance(AttendanceS attendanceS) throws SQLException {
        String query ="UPDATE attendance SET id_subject = '"+attendanceS.getIdSubject().getId()+"',  id_stud = '"+attendanceS.getIdStud().getId()+"',date_attendance=' "+attendanceS.getDate()+"',fact_of_presence=' "+attendanceS.getFactOfPresence()+"' WHERE id_subject ='"+attendanceS.getOldIdSubject().getId()+"'AND  id_stud = '"+attendanceS.getOldIdStud().getId();
        Connect connect = new Connect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connect.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            AttendanceUpdate.FLAG_UPDATE_ATTENDANCE = true;
        }
        catch (Exception e){
            System.out.println(e);
            AttendanceUpdate.FLAG_UPDATE_ATTENDANCE = false;
            AttendanceUpdate.TEXT_ERROR = e.toString();

        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }

    @Override
    public Attendance getAttendance(int idStud, int idSubject) throws SQLException {
        String query ="SELECT * FROM attendance WHERE id_subject ='"+idSubject+"'AND  id_stud = '"+idStud;
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Attendance attendance = null;
        SubjectSelect  subjectSelect = null;
        StudSelect studSelect = null;
        try{
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            attendance = new Attendance();
            studSelect = new StudSelect();
            subjectSelect = new SubjectSelect();
            attendance.setFactOfPresence(resultSet.getBoolean("fact_of_presence"));
            attendance.setDate(resultSet.getString("date_attendance"));
            Integer idSt = new Integer(resultSet.getInt("id_stud"));
            Integer idSu = new Integer(resultSet.getInt("id_subject"));
            attendance.setIdStud(studSelect.getStud(idSt));
            attendance.setIdSubject(subjectSelect.getSubject(idSu));
        }
        catch (Exception e){

            //логирование
        }

        finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return attendance;
    }

    @Override
    public List<Attendance> getAttendance() throws SQLException {
        List<Attendance> listAttendance= new ArrayList<Attendance>();
        String query ="SELECT * FROM attendance";
        Connect connect = new Connect();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Attendance attendance = null;
        SubjectSelect  subjectSelect = null;
        StudSelect studSelect = null;
        try {
            connection = connect.getConnect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                attendance = new Attendance();
                studSelect = new StudSelect();
                subjectSelect = new SubjectSelect();
                attendance.setFactOfPresence(resultSet.getBoolean("fact_of_presence"));
                attendance.setDate(resultSet.getString("date_attendance"));
                Integer idSt = new Integer(resultSet.getInt("id_stud"));
                Integer idSu = new Integer(resultSet.getInt("id_subject"));
                attendance.setIdStud(studSelect.getStud(idSt));
                attendance.setIdSubject(subjectSelect.getSubject(idSu));
                listAttendance.add(attendance);

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


        return listAttendance;
    }
}
