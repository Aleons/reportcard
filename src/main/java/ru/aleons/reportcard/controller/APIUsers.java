package ru.aleons.reportcard.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.aleons.reportcard.dao.query.add.UsersAdd;
import ru.aleons.reportcard.dao.query.delete.UsersDelete;
import ru.aleons.reportcard.dao.query.select.SuperUserSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.UsersUpdate;
import ru.aleons.reportcard.model.Users;
import ru.aleons.reportcard.model.message.Message;
import ru.aleons.reportcard.model.signature.UsersS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class APIUsers {
    @RequestMapping(value = "getallusers",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Users> getAllUsers() throws SQLException, NoSuchAlgorithmException {

            UsersSelect usersSelect = new UsersSelect();
            return usersSelect.getAllUsers();

    }
    @RequestMapping(value = "addusers",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message addUsers(@RequestBody UsersS usersS) throws SQLException, NoSuchAlgorithmException {
        UsersAdd usersAdd = new UsersAdd();
        Message message = new Message();
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (usersS.getSignature().equals(superUserSelect.getSuperUserHash(usersS.getSignature()))) {
            usersAdd.addUsers(usersS);
            if(UsersAdd.FLAG_ADD_USERS==true) {
                message.setStatus("Successful");
                message.setText("Пользователь " + usersS.getLogin() + " успешно добавлен");
                return message;
            }

            else  {
                message.setStatus("Failed");
                message.setText(UsersAdd.TEXT_ERROR);
                return message;
            }}
        else {
            message.setStatus("Failed");
            message.setText("Error signature");
            return message;
        }


    }



    @RequestMapping(value = "getuser",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Users getUser(@RequestBody UsersS usersS) throws SQLException, NoSuchAlgorithmException {
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (usersS.getSignature().equals(superUserSelect.getSuperUserHash(usersS.getSignature()))) {
            UsersSelect usersSelect = new UsersSelect();
            return usersSelect.getUsers(usersS.getLogin());
        }
        else {
            Users users = new Users();
            return users;
        }
    }

    @RequestMapping(value = "updateusers",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message updateUsers(@RequestBody UsersS usersS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        SuperUserSelect superUserSelect = new SuperUserSelect();
        UsersUpdate usersUpdate = new UsersUpdate();
        UsersSelect usersSelect = new UsersSelect();
        String n = usersSelect.getUsers(usersS.getOldLogin()).getLogin();
        String m = usersSelect.getUsers(usersS.getLogin()).getLogin();
        if (usersS.getSignature().equals(superUserSelect.getSuperUserHash(usersS.getSignature())))  {
        if (n==null){
            message.setStatus("Failed");
            message.setText("Объект не обновлен");
            return message;
        }
            if ((n.equals(usersS.getOldLogin())) && (m == null || m.equals(n))) {
                usersUpdate.usersUpdate(usersS);
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

    @RequestMapping(value = "getalluser",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Users> getAllUser(@RequestBody UsersS usersS) throws SQLException, NoSuchAlgorithmException {
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (usersS.getSignature().equals(superUserSelect.getSuperUserHash(usersS.getSignature()))) {
            UsersSelect usersSelect = new UsersSelect();
            return usersSelect.getAllUsers();
        } else {
            return null;

        }
    }


    @RequestMapping(value = "deleteusers",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Message deleteUsers(@RequestBody UsersS usersS) throws SQLException, NoSuchAlgorithmException {
        Message message = new Message();
        SuperUserSelect superUserSelect = new SuperUserSelect();
        if (usersS.getSignature().equals(superUserSelect.getSuperUserHash(usersS.getSignature()))) {
            UsersDelete usersDelete = new UsersDelete();

            UsersSelect usersSelect = new UsersSelect();
            if (usersSelect.getUsers(usersS.getLogin()).getLogin() != null) {
                usersDelete.deleteUsers(usersS.getLogin());
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
