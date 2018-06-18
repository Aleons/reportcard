package ru.aleons.reportcard.controller;

import org.springframework.web.bind.annotation.*;
import ru.aleons.reportcard.dao.query.add.TabelAdd;
import ru.aleons.reportcard.dao.query.delete.TabelDelete;
import ru.aleons.reportcard.dao.query.select.StudSelect;
import ru.aleons.reportcard.dao.query.select.TabelSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.TabelUpdate;
import ru.aleons.reportcard.model.Labs;
import ru.aleons.reportcard.model.Stud;
import ru.aleons.reportcard.model.Tabel;
import ru.aleons.reportcard.model.message.Message;
import ru.aleons.reportcard.model.signature.TabelS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tabel")
public class APITabel {
    @RequestMapping(value = "gettabel",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Tabel getAttendance(@RequestBody TabelS tabelS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();;
        if (tabelS.getSignature().equals(usersSelect.getUserHash(tabelS.getSignature()))) {
            TabelSelect tabelSelect = new TabelSelect();
            return tabelSelect.getTabel(tabelS.getIdStud().getId(),tabelS.getIdLabs().getId());
        }
        else {
            Tabel tabel = new Tabel();
            return tabel;
        }
    }
    @RequestMapping(value = "getalltabel",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Tabel> getAllTabel(@RequestBody TabelS tabelS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();
        if (tabelS.getSignature().equals(usersSelect.getUserHash(tabelS.getSignature()))) {
            TabelSelect tabelSelect = new TabelSelect();
            return tabelSelect.getAllTabel();
        }
        else {
            List<Tabel> tabels = new ArrayList<Tabel>();
            return tabels;
        }

    }
    @RequestMapping(value = "addtabel",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message addTabel(@RequestBody TabelS tabelS) throws SQLException, NoSuchAlgorithmException {
        TabelAdd tabelAdd = new TabelAdd();
        Message message = new Message();
        UsersSelect usersSelect = new UsersSelect();
        if (tabelS.getSignature().equals(usersSelect.getUserHash(tabelS.getSignature()))) {
            tabelAdd.addTabel(tabelS.getIdLabs(),tabelS.getIdStud(),tabelS.getDate(),tabelS.getPoint());
            if (TabelAdd.FLAG_ADD_TABEL == true) {
                message.setStatus("Successful");
                StudSelect studSelect = new StudSelect();
                message.setText(" Оценка студенту   " + studSelect.getStud(tabelS.getIdStud().getId()).getFio() + " успешно поставлена");
                return message;
            } else {
                message.setStatus("Failed");
                message.setText(tabelAdd.TEXT_ERROR);
                return message;
            }
        }
        else{
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }
    }

    @RequestMapping(value = "updatetabel",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message updateTabel(@RequestBody TabelS tabelS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        TabelSelect attendanceS = new TabelSelect();
        UsersSelect usersSelect = new UsersSelect();
        Labs idLa = new Labs(tabelS.getIdLabs().getId());
        Stud idSt = new Stud(tabelS.getIdStud().getId());
        if (tabelS.getSignature().equals(usersSelect.getUserHash(tabelS.getSignature()))) {
            if (idSt.getId()==tabelS.getIdStud().getId() && idLa.getId()==tabelS.getIdLabs().getId()){
                try {
                    TabelUpdate tabelUpdate = new TabelUpdate();
                    tabelUpdate.tableUpdate(tabelS);
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
    @RequestMapping(value = "deletetabel",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message deleteTabel(@RequestBody TabelS tabelS) throws SQLException, NoSuchAlgorithmException {

        Message message = new Message();
        TabelSelect tabelSelect = new TabelSelect();
        UsersSelect usersSelect = new UsersSelect();
        if (tabelS.getSignature().equals(usersSelect.getUserHash(tabelS.getSignature()))) {
            TabelDelete tabelDelete = new TabelDelete();
            if (tabelSelect.getTabel(tabelS.getIdStud().getId(), tabelS.getIdLabs().getId()).getIdStud().getId() == tabelS.getIdStud().getId() && tabelSelect.getTabel(tabelS.getIdStud().getId(), tabelS.getIdLabs().getId()).getIdLabs().getId() == tabelS.getIdLabs().getId()) {
                tabelDelete.deleteTable(tabelS.getIdLabs().getId(), tabelS.getIdStud().getId());
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
