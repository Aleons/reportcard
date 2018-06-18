package ru.aleons.reportcard.dao.query.delete;

import ru.aleons.reportcard.dao.implementation.AttendanceDaoImpl;
import ru.aleons.reportcard.dao.interfaces.AttendanceDao;

import java.sql.SQLException;

public class AttendanceDelete {
    public static boolean FLAG_DELETE_ATTENDANCE = true;
    public static String TEXT_ERROR ="";
    public void deleteAttendance(int idSubject, int idSud) throws SQLException {
        AttendanceDao attendanceDao = new AttendanceDaoImpl();
        attendanceDao.delAttendance(idSud, idSubject);
    }
}
