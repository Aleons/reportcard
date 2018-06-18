package ru.aleons.reportcard.controller;


import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.aleons.reportcard.model.Users;

@RestController
@RequestMapping("/authorization")
public class APIAuthorization {
    @RequestMapping(value = "",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody
    public Users test(@RequestBody Users user){
        Users users = new Users();
        users.setLogin(user.getLogin());
        users.setPass(user.getPass());
        return users;
    }
}
