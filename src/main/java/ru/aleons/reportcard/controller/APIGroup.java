package ru.aleons.reportcard.controller;

import org.springframework.web.bind.annotation.*;
import ru.aleons.reportcard.dao.query.add.GroupAdd;
import ru.aleons.reportcard.dao.query.delete.GroupDelete;
import ru.aleons.reportcard.dao.query.select.GroupsSelect;
import ru.aleons.reportcard.dao.query.select.PulpitSelect;
import ru.aleons.reportcard.dao.query.select.SuperUserSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.GroupUpdate;
import ru.aleons.reportcard.model.Groups;
import ru.aleons.reportcard.model.message.Message;
import ru.aleons.reportcard.model.signature.GroupsS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class APIGroup {
    @RequestMapping(value = "getgroup",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Groups getGroups(@RequestBody GroupsS groupsS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();;
        if (groupsS.getSignature().equals(usersSelect.getUserHash(groupsS.getSignature()))) {
            GroupsSelect groupsSelect = new GroupsSelect();
            return groupsSelect.getGroups(groupsS.getId());
        }
        else {
            Groups groups = new Groups();
            return groups;
        }
    }

    @RequestMapping(value = "getallgroup",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Groups> getAllGroups(@RequestBody GroupsS groupsS) throws SQLException, NoSuchAlgorithmException {
        UsersSelect usersSelect = new UsersSelect();
        if (groupsS.getSignature().equals(usersSelect.getUserHash(groupsS.getSignature()))) {
            GroupsSelect groupsSelect = new GroupsSelect();
            return groupsSelect.getAllGroups();
        }
        else {
            List<Groups> groups = new ArrayList<Groups>();
            return groups;
        }

    }


    @RequestMapping(value = "addgroup",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message addGroups(@RequestBody GroupsS groupsS) throws SQLException, NoSuchAlgorithmException {
        GroupAdd groupAdd = new GroupAdd();
        Message message = new Message();
        UsersSelect usersSelect = new UsersSelect();
        PulpitSelect pulpitSelect = new PulpitSelect();
        if (groupsS.getSignature().equals(usersSelect.getUserHash(groupsS.getSignature()))) {
            groupAdd.addGroup(groupsS.getNameGroups(), usersSelect.getUsers(groupsS.getUsers().getLogin()).getLogin(),pulpitSelect.getPulpit(groupsS.getNumberPulpit().getNumberPulpit()).getNumberPulpit());
            if(GroupAdd.FLAG_ADD_GROUP==true) {
                message.setStatus("Successful");
                message.setText("Группа " + groupsS.getNameGroups() + " успешно добавлена");
                return message;
            }

            else  {
                message.setStatus("Failed");
                message.setText(GroupAdd.TEXT_ERROR);
                return message;
            }}
        else {
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }


    }


    @RequestMapping(value = "updategroup",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message updateGroups(@RequestBody GroupsS groupsS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        UsersSelect userSelect = new UsersSelect();
        GroupUpdate groupUpdate = new GroupUpdate();
        GroupsSelect groupsSelect = new GroupsSelect();
        Groups n = groupsSelect.getGroups(groupsS.getId());

        if (groupsS.getSignature().equals(userSelect.getUserHash(groupsS.getSignature())))  {
            if (n.getId()==groupsS.getId()){
                try {
                    groupUpdate.groupUpdate(groupsS);
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


    @RequestMapping(value = "deletegroup",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message deleteGroups(@RequestBody GroupsS groupsS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        UsersSelect userSelect = new UsersSelect();
        if (groupsS.getSignature().equals(userSelect.getUserHash(groupsS.getSignature())))  {
            GroupDelete groupDelete = new GroupDelete();
            UsersSelect usersSelect = new UsersSelect();
            GroupsSelect groupsSelect = new GroupsSelect();
            if (groupsSelect.getGroups(groupsS.getId()).getId()==groupsS.getId()) {
                groupDelete.deleteGroup(groupsS.getId());
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
