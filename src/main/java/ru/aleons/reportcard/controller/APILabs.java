package ru.aleons.reportcard.controller;

import org.springframework.web.bind.annotation.*;
import ru.aleons.reportcard.dao.query.add.LabsAdd;
import ru.aleons.reportcard.dao.query.delete.LabsDelete;
import ru.aleons.reportcard.dao.query.select.LabsSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.LabsUpdate;
import ru.aleons.reportcard.model.Labs;
import ru.aleons.reportcard.model.message.Message;
import ru.aleons.reportcard.model.signature.LabsS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/labs")
public class APILabs {

    @RequestMapping(value = "getalllabs",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Labs> getAllLabs(@RequestBody LabsS labsS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();
        if (labsS.getSignature().equals(usersSelect.getUserHash(labsS.getSignature()))) {
            LabsSelect labsSelect = new LabsSelect();
            return labsSelect.getAllLabs();
        }
        else {
            List<Labs> studs = new ArrayList<Labs>();
            return studs;
        }

    }

    @RequestMapping(value = "getlabs",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Labs getStud(@RequestBody LabsS labsS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();
        if (labsS.getSignature().equals(usersSelect.getUserHash(labsS.getSignature()))) {
            LabsSelect labsSelect = new LabsSelect();
            return labsSelect.getLabs(labsS.getId());
        }
        else {
            Labs labs = new Labs();
            return labs;
        }
    }

    @RequestMapping(value = "addlabs",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message addLabs(@RequestBody LabsS labsS) throws SQLException, NoSuchAlgorithmException {
        LabsAdd labsAdd = new LabsAdd();
        Message message = new Message();
        UsersSelect usersSelect = new UsersSelect();
        if (labsS.getSignature().equals(usersSelect.getUserHash(labsS.getSignature()))) {
            labsAdd.addLabs(labsS.getIdSubject().getId(),labsS.getNumberLr(),labsS.getDescription());
            if (LabsAdd.FLAG_ADD_Labs == true) {
                message.setStatus("Successful");
                message.setText(" Лабораторная работа  " + labsS.getNumberLr() + " успешно добавлена");
                return message;
            } else {
                message.setStatus("Failed");
                message.setText(labsAdd.TEXT_ERROR);
                return message;
            }
        }
        else{
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }
    }

    @RequestMapping(value = "updatelabs",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message updateLabs(@RequestBody LabsS labsS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        LabsSelect labsSelect = new LabsSelect();
        UsersSelect usersSelect = new UsersSelect();
        Labs id = labsSelect.getLabs(labsS.getId());
        if (labsS.getSignature().equals(usersSelect.getUserHash(labsS.getSignature()))) {
            if (id.getId()==labsS.getId()){
                try {
                    LabsUpdate labsUpdate = new LabsUpdate();
                    labsUpdate.labsUpdate(labsS);
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

    @RequestMapping(value = "deletelabs",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message deleteLabs(@RequestBody LabsS labsS) throws SQLException, NoSuchAlgorithmException {

        Message message = new Message();
        LabsSelect labsSelect = new LabsSelect();;
        UsersSelect usersSelect = new UsersSelect();
        if (labsS.getSignature().equals(usersSelect.getUserHash(labsS.getSignature()))) {
            LabsDelete labsDelete = new LabsDelete();
            if (labsSelect.getLabs(labsS.getId()).getId()==labsS.getId()) {
                labsDelete.deleteLabs(labsS.getId());
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
