package ru.aleons.reportcard.controller;

import org.springframework.web.bind.annotation.*;
import ru.aleons.reportcard.dao.query.add.AttendanceAdd;
import ru.aleons.reportcard.dao.query.delete.AttendanceDelete;
import ru.aleons.reportcard.dao.query.select.AttendanceSelect;
import ru.aleons.reportcard.dao.query.select.StudSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.AttendanceUpdate;
import ru.aleons.reportcard.model.Attendance;
import ru.aleons.reportcard.model.Stud;
import ru.aleons.reportcard.model.Subject;
import ru.aleons.reportcard.model.message.Message;
import ru.aleons.reportcard.model.signature.AttendanceS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class APIAttendance {
    @RequestMapping(value = "getattendance",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Attendance getAttendance(@RequestBody AttendanceS attendanceS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();;
        if (attendanceS.getSignature().equals(usersSelect.getUserHash(attendanceS.getSignature()))) {
            AttendanceSelect attendanceSelect = new AttendanceSelect();
            return attendanceSelect.getAttendance(attendanceS.getIdStud().getId(),attendanceS.getIdSubject().getId());
        }
        else {
            Attendance  attendance = new Attendance();
            return attendance;
        }
    }
    @RequestMapping(value = "getallattendance",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Attendance> getAllAttendance(@RequestBody AttendanceS attendanceS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();
        if (attendanceS.getSignature().equals(usersSelect.getUserHash(attendanceS.getSignature()))) {
            AttendanceSelect attendanceSelect = new AttendanceSelect();
            return attendanceSelect.getAllAttendance();
        }
        else {
            List<Attendance> attendances = new ArrayList<Attendance>();
            return attendances;
        }

    }

    @RequestMapping(value = "addattendance",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message addAttendance(@RequestBody AttendanceS attendanceS) throws SQLException, NoSuchAlgorithmException {
        AttendanceAdd attendanceAdd = new AttendanceAdd();
        Message message = new Message();
        UsersSelect usersSelect = new UsersSelect();
        if (attendanceS.getSignature().equals(usersSelect.getUserHash(attendanceS.getSignature()))) {
            attendanceAdd.addAttendance(attendanceS.getIdSubject(),attendanceS.getIdStud(),attendanceS.getDate(),attendanceS.getFactOfPresence());
            if (AttendanceAdd.FLAG_ADD_ATTENDANCE == true) {
                message.setStatus("Successful");
                StudSelect studSelect = new StudSelect();
                message.setText(" Посещаемость студенту   " + studSelect.getStud(attendanceS.getIdStud().getId()).getFio() + " успешно поставлена");
                return message;
            } else {
                message.setStatus("Failed");
                message.setText(AttendanceAdd.TEXT_ERROR);
                return message;
            }
        }
        else{
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }
    }

    @RequestMapping(value = "updateattendance",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message updateAttendance(@RequestBody AttendanceS attendanceS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        AttendanceSelect attendanceSelect = new AttendanceSelect();
        UsersSelect usersSelect = new UsersSelect();
        Subject idSu = new Subject(attendanceS.getIdSubject().getId());
        Stud idSt = new Stud(attendanceS.getIdStud().getId());
        if (attendanceS.getSignature().equals(usersSelect.getUserHash(attendanceS.getSignature()))) {
            if (idSt.getId()==attendanceS.getIdStud().getId() && idSu.getId()==attendanceS.getIdSubject().getId()){
                try {
                    AttendanceUpdate attendanceUpdate = new AttendanceUpdate();
                    attendanceUpdate.attendanceUpdate(attendanceS);
                    message.setStatus("Successful");
                    message.setText("Объект успешно обновлен");
                }
                catch (Exception e){
                    message.setStatus("Failed");
                    message.setText("Объект не обновлен");
                }

                return message;
            }
        } else {
            message.setStatus("Failed");
            message.setText("Объект не обновлен");
        }

        return message;
    }
    @RequestMapping(value = "deleteattendance",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message deleteAttendance(@RequestBody AttendanceS attendanceS) throws SQLException, NoSuchAlgorithmException {

        Message message = new Message();
        AttendanceSelect attendanceSelect = new AttendanceSelect();
        UsersSelect usersSelect = new UsersSelect();
        if (attendanceS.getSignature().equals(usersSelect.getUserHash(attendanceS.getSignature()))) {
            AttendanceDelete attendanceDelete = new AttendanceDelete();
            if (attendanceSelect.getAttendance(attendanceS.getIdStud().getId(),attendanceS.getIdSubject().getId()).getIdStud().getId()==attendanceS.getIdStud().getId() && attendanceSelect.getAttendance(attendanceS.getIdStud().getId(),attendanceS.getIdSubject().getId()).getIdSubject().getId()==attendanceS.getIdSubject().getId()) {
                attendanceDelete.deleteAttendance(attendanceS.getIdSubject().getId(),attendanceS.getIdStud().getId());
                message.setStatus("Successful");
                message.setText("Объект успешно удален");
            } else {
                message.setStatus("Failed");
                message.setText("Объект не удален");
            }

            return message;
        } else {
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }
    }
}
