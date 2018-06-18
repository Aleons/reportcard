package ru.aleons.reportcard.dao.interfaces;

import ru.aleons.reportcard.model.Attendance;
import ru.aleons.reportcard.model.signature.AttendanceS;

import java.sql.SQLException;
import java.util.List;

public interface AttendanceDao {
    public void addAttendance (Attendance attendance) throws SQLException;
    public void delAttendance (int idStud, int idSubject) throws SQLException;
    public void updateAttendance (AttendanceS attendanceS) throws SQLException;
    public  Attendance getAttendance (int idStud, int idSubject) throws SQLException;
    public List<Attendance> getAttendance() throws SQLException;
}
