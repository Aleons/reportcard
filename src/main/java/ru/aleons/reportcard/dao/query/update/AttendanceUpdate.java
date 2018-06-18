package ru.aleons.reportcard.dao.query.update;

import ru.aleons.reportcard.dao.implementation.AttendanceDaoImpl;
import ru.aleons.reportcard.dao.interfaces.AttendanceDao;
import ru.aleons.reportcard.model.signature.AttendanceS;

import java.sql.SQLException;

public class AttendanceUpdate {
    public static boolean FLAG_UPDATE_ATTENDANCE = true;
    public static String TEXT_ERROR ="";
    public void attendanceUpdate(AttendanceS attendanceS) throws SQLException {
        AttendanceDao attendanceDao = new AttendanceDaoImpl();
        attendanceDao.updateAttendance(attendanceS);
    }
}
