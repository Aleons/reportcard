package ru.aleons.reportcard.controller;

import ru.aleons.reportcard.config.HashMD5;
import ru.aleons.reportcard.dao.implementation.GroupDaoImpl;
import ru.aleons.reportcard.dao.query.add.GroupAdd;
import ru.aleons.reportcard.dao.query.add.PulpitAdd;
import ru.aleons.reportcard.dao.query.add.UsersAdd;
import ru.aleons.reportcard.dao.query.delete.GroupDelete;
import ru.aleons.reportcard.dao.query.delete.PulpitDelete;
import ru.aleons.reportcard.dao.query.select.*;

import ru.aleons.reportcard.dao.query.update.GroupUpdate;
import ru.aleons.reportcard.dao.query.update.PulpitUpdate;
import ru.aleons.reportcard.dao.query.update.UsersUpdate;
import ru.aleons.reportcard.model.Groups;
import ru.aleons.reportcard.model.Pulpit;
import ru.aleons.reportcard.model.Subject;
import ru.aleons.reportcard.model.Users;
import ru.aleons.reportcard.model.signature.GroupsS;
import ru.aleons.reportcard.model.signature.PulpitS;
import ru.aleons.reportcard.model.signature.UsersS;


import javax.crypto.Cipher;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
//        PulpitAdd pulpitAdd = new PulpitAdd();
//        PulpitDelete pulpitDelete = new PulpitDelete();
//        PulpitSelect pulpitSelect =new PulpitSelect();
//        PulpitUpdate pulpitUpdate = new PulpitUpdate();
//        System.out.println(pulpitSelect.getAllPulpit());
//        SuperUserSelect superUserSelect = new SuperUserSelect();
//        //System.out.println(superUserSelect.getSuperUserHash("f6fffe48c908deb0f4c3bd36c032e72"));
//        UsersSelect usersSelect = new UsersSelect();
//        System.out.println(usersSelect.getUsers("admin").getFio());
//        UsersUpdate usersUpdate = new UsersUpdate();
//        UsersS usersS = new UsersS("test1","test","test","test","test",4,"f6fdffe48c908deb0f4c3bd36c032e72");
//        //usersUpdate.usersUpdate(usersS);
//        GroupsSelect groupsSelect = new GroupsSelect();
//        UsersAdd usersAdd = new UsersAdd();
//        GroupAdd groupAdd = new GroupAdd();
//        GroupsS groups = new GroupsS();
//        groups.setId(4);
//        groups.setNameGroups("2326");
//        groups.setNumberPulpit(new Pulpit(44,null));
//        groups.setUsers(new Users("test",null,null,null,4));
//        GroupDaoImpl groupDao = new GroupDaoImpl();
//        //groupDao.updateGroup(groups);
//        //groupAdd.addGroup("4545","test",4);
//        GroupUpdate groupUpdate = new GroupUpdate();
//        //groupUpdate.groupUpdate(groups);
//        GroupDelete groupDelete = new GroupDelete();
//        groupDelete.deleteGroup(4);

        //System.out.println(groupsSelect.getGroups(1).getNameGroups());
        SubjectSelect subjectSelect = new SubjectSelect();
        Subject subject = subjectSelect.getAllSubjects().get(0);







        }
}
