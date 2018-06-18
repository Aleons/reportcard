package ru.aleons.reportcard.dao.query.add;

import ru.aleons.reportcard.dao.implementation.AttendanceDaoImpl;
import ru.aleons.reportcard.dao.implementation.GroupDaoImpl;
import ru.aleons.reportcard.dao.interfaces.AttendanceDao;
import ru.aleons.reportcard.model.*;

import java.sql.SQLException;

public class AttendanceAdd {
    public static boolean FLAG_ADD_ATTENDANCE = true;
    public static String TEXT_ERROR ="";
    public void addAttendance(Subject idSubject, Stud idStud, String date, boolean factOfPresence) throws SQLException {
        Stud stud = new Stud(idStud.getId());
        Subject subject = new Subject(idSubject.getId());
        Attendance attendance = new Attendance(stud,subject, date, factOfPresence);
        AttendanceDao attendanceDao = new AttendanceDaoImpl();
        attendanceDao.addAttendance(attendance);
    }
}
