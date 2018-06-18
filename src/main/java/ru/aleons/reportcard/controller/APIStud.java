package ru.aleons.reportcard.controller;

import org.springframework.web.bind.annotation.*;
import ru.aleons.reportcard.dao.query.add.StudAdd;
import ru.aleons.reportcard.dao.query.delete.StudDelete;
import ru.aleons.reportcard.dao.query.select.GroupsSelect;
import ru.aleons.reportcard.dao.query.select.StudSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.StudUpdate;
import ru.aleons.reportcard.model.Groups;
import ru.aleons.reportcard.model.Stud;
import ru.aleons.reportcard.model.message.Message;
import ru.aleons.reportcard.model.signature.StudS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stud")
public class APIStud {

    @RequestMapping(value = "getallstud",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Stud> getAllStud(@RequestBody StudS studS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();
        if (studS.getSignature().equals(usersSelect.getUserHash(studS.getSignature()))) {
            StudSelect studSelect = new StudSelect();
            return studSelect.getAllStud();
        }
        else {
            List<Stud> studs = new ArrayList<Stud>();
            return studs;
        }

    }

    @RequestMapping(value = "getstud",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Stud getStud(@RequestBody StudS studS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();
        if (studS.getSignature().equals(usersSelect.getUserHash(studS.getSignature()))) {
            StudSelect studSelect = new StudSelect();
            return studSelect.getStud(studS.getId());
        }
        else {
            Stud stud = new Stud();
            return stud;
        }
    }

    @RequestMapping(value = "addstud",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message addStud(@RequestBody StudS studS) throws SQLException, NoSuchAlgorithmException {
        StudAdd studAdd = new StudAdd();
        Message message = new Message();
        UsersSelect usersSelect = new UsersSelect();
        if (studS.getSignature().equals(usersSelect.getUserHash(studS.getSignature()))) {
            studAdd.addStud(studS.getFio(), studS.getIdGroups().getId(), studS.getContact());
            if (StudAdd.FLAG_ADD_STUD == true) {
                message.setStatus("Successful");
                message.setText("Студент " + studS.getFio() + " успешно добавлен");
                return message;
            } else {
                message.setStatus("Failed");
                message.setText(StudAdd.TEXT_ERROR);
                return message;
            }
        }
        else{
                message.setStatus("Failed");
                message.setText("Error signature");
                return message;
            }
    }

    @RequestMapping(value = "updatestud",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message updateStud(@RequestBody StudS studS) throws SQLException, NoSuchAlgorithmException {
        StudAdd studAdd = new StudAdd();
        Message message = new Message();
        StudSelect studSelect = new StudSelect();
        UsersSelect usersSelect = new UsersSelect();
        Stud n = studSelect.getStud(studS.getId());

        if (studS.getSignature().equals(usersSelect.getUserHash(studS.getSignature())))  {
            if (n.getId()==studS.getId()){
                try {
                    StudUpdate studUpdate = new StudUpdate();
                    studUpdate.studUpdate(studS);
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

    @RequestMapping(value = "deletestud",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message deleteStud(@RequestBody StudS studS) throws SQLException, NoSuchAlgorithmException {

        Message message = new Message();
        StudSelect studSelect = new StudSelect();
        UsersSelect usersSelect = new UsersSelect();
        if (studS.getSignature().equals(usersSelect.getUserHash(studS.getSignature())))  {
            StudDelete studDelete = new StudDelete();
            if (studSelect.getStud(studS.getId()).getId()==studS.getId()) {
                studDelete.deleteStud(studS.getId());
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
