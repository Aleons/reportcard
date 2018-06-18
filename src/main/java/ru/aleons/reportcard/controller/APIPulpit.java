package ru.aleons.reportcard.controller;

import org.springframework.web.bind.annotation.*;

import ru.aleons.reportcard.config.HashMD5;
import ru.aleons.reportcard.dao.query.add.PulpitAdd;
import ru.aleons.reportcard.dao.query.delete.PulpitDelete;
import ru.aleons.reportcard.dao.query.select.PulpitSelect;
import ru.aleons.reportcard.dao.query.select.SuperUserSelect;
import ru.aleons.reportcard.dao.query.update.PulpitUpdate;
import ru.aleons.reportcard.model.Pulpit;
import ru.aleons.reportcard.model.message.Message;
import ru.aleons.reportcard.model.signature.PulpitS;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pulpit")
public class APIPulpit {

    @RequestMapping(value = "getpulpit",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Pulpit getPulpit(@RequestBody PulpitS pulpitS) throws SQLException, NoSuchAlgorithmException {
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (pulpitS.getSignature().equals(superUserSelect.getSuperUserHash(pulpitS.getSignature()))) {
            PulpitSelect pulpitSelect = new PulpitSelect();
            return pulpitSelect.getPulpit(pulpitS.getNumberPulpit());
        }
        else {
            Pulpit pulpit = new Pulpit();
            return pulpit;
        }
    }

    @RequestMapping(value = "getallpulpit",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Pulpit> getAllPulpit(@RequestBody PulpitS pulpitS) throws SQLException, NoSuchAlgorithmException {
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (pulpitS.getSignature().equals(superUserSelect.getSuperUserHash(pulpitS.getSignature()))) {
            PulpitSelect pulpitSelect = new PulpitSelect();
            return pulpitSelect.getAllPulpit();
            }
            else {
                List<Pulpit> pulpits = new ArrayList<Pulpit>();
                return pulpits;
        }

    }

    @RequestMapping(value = "addpulpit",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message addPulpit(@RequestBody PulpitS pulpitS) throws SQLException, NoSuchAlgorithmException {
        PulpitAdd pulpitAdd = new PulpitAdd();
        Message message = new Message();
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (pulpitS.getSignature().equals(superUserSelect.getSuperUserHash(pulpitS.getSignature()))) {
            pulpitAdd.addPulpit(pulpitS.getNumberPulpit(),pulpitS.getName());

            if(PulpitAdd.FLAG_ADD_PULPIT==true) {
                message.setStatus("Successful");
                message.setText("Кафедра " + pulpitS.getName() + " успешно добавлена");
                return message;
            }

            else  {
            message.setStatus("Failed");
            message.setText(PulpitAdd.TEXT_ERROR);
            return message;
        }}
        else {
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }


    }

    @RequestMapping(value = "deletepulpit",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message deletePulpit(@RequestBody PulpitS pulpitS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (pulpitS.getSignature().equals(superUserSelect.getSuperUserHash(pulpitS.getSignature())))  {
            PulpitDelete pulpitDelete = new PulpitDelete();

            PulpitSelect pulpitSelect = new PulpitSelect();
            if (pulpitSelect.getPulpit(pulpitS.getNumberPulpit()).getNumberPulpit() != 0) {
                pulpitDelete.deletePulpit(pulpitS.getNumberPulpit());
                message.setStatus("Successful");
                message.setText("Объект успешно удален");
            } else {
                message.setStatus("Failed");
                message.setText("Объект не удален");
            }

            return message;
        }
        else {
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }

    }

    @RequestMapping(value = "updatepulpit",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message updatePulpit(@RequestBody PulpitS pulpitS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (pulpitS.getSignature().equals(superUserSelect.getSuperUserHash(pulpitS.getSignature())))  {
            PulpitUpdate pulpitUpdate = new PulpitUpdate();

            PulpitSelect pulpitSelect = new PulpitSelect();
            int n = pulpitSelect.getPulpit(pulpitS.getOldNumberPulpit()).getNumberPulpit();
            int m = pulpitSelect.getPulpit(pulpitS.getNumberPulpit()).getNumberPulpit();
            if (n == pulpitS.getOldNumberPulpit() && m!=pulpitS.getNumberPulpit()) {
                pulpitUpdate.pulpitUpdate(pulpitS);
                message.setStatus("Successful");
                message.setText("Объект успешно обновлен");
            } else {
                message.setStatus("Failed");
                message.setText("Объект не обновлен");
            }

            return message;
        }
        else {
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }

    }


}
