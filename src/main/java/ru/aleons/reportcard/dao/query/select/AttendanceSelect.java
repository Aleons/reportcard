package ru.aleons.reportcard.dao.query.select;

import ru.aleons.reportcard.dao.implementation.AttendanceDaoImpl;
import ru.aleons.reportcard.model.Attendance;

import java.sql.SQLException;
import java.util.List;

public class AttendanceSelect {
    public Attendance getAttendance(int idStud, int idSubject) throws SQLException {
        AttendanceDaoImpl attendanceDao = new AttendanceDaoImpl();
        return attendanceDao.getAttendance(idStud,idSubject);
    }

    public List<Attendance> getAllAttendance() throws SQLException {
        AttendanceDaoImpl attendanceDao = new AttendanceDaoImpl();
        return attendanceDao.getAttendance();
    }
}
