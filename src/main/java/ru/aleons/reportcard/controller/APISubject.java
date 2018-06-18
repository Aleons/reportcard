package ru.aleons.reportcard.controller;

import org.springframework.web.bind.annotation.*;
import ru.aleons.reportcard.dao.query.add.SubjectAdd;
import ru.aleons.reportcard.dao.query.delete.SubjectDelete;
import ru.aleons.reportcard.dao.query.select.AttendanceSelect;
import ru.aleons.reportcard.dao.query.select.SubjectSelect;
import ru.aleons.reportcard.dao.query.select.UsersSelect;
import ru.aleons.reportcard.dao.query.update.SubjectUpdate;
import ru.aleons.reportcard.model.Subject;
import ru.aleons.reportcard.model.message.Message;
import ru.aleons.reportcard.model.signature.SubjectS;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    @RestController
    @RequestMapping("/subject")
    public class APISubject {
        @RequestMapping(value = "getsubject", method = RequestMethod.POST, headers = {"Content-type=application/json"})
        @ResponseBody
        public Subject getSubject(@RequestBody SubjectS subjectS) throws SQLException, NoSuchAlgorithmException {
            UsersSelect usersSelect = new UsersSelect();
            if (subjectS.getSignature().equals(usersSelect.getUserHash(subjectS.getSignature()))) {
                SubjectSelect subjectSelect = new SubjectSelect();
                return subjectSelect.getSubject(subjectS.getId());
            } else {
                Subject subject = new Subject();
                return subject;
            }
        }

        @RequestMapping(value = "getallsubject", method = RequestMethod.POST, headers = {"Content-type=application/json"})
        @ResponseBody
        public List<Subject> getAllSubject(@RequestBody SubjectS subjectS) throws SQLException, NoSuchAlgorithmException {
            UsersSelect usersSelect = new UsersSelect();
            if (subjectS.getSignature().equals(usersSelect.getUserHash(subjectS.getSignature()))) {
                SubjectSelect subjectSelect = new SubjectSelect();
                return subjectSelect.getAllSubjects();
            } else {
                List<Subject> subjects = new ArrayList<Subject>();
                return subjects;
            }

        }


        @RequestMapping(value = "addsubject", method = RequestMethod.POST, headers = {"Content-type=application/json"})
        @ResponseBody
        public Message addSubject(@RequestBody SubjectS subjectS) throws SQLException, NoSuchAlgorithmException {
            SubjectAdd subjectAdd = new SubjectAdd();
            Message message = new Message();
            UsersSelect usersSelect = new UsersSelect();
            if (subjectS.getSignature().equals(usersSelect.getUserHash(subjectS.getSignature()))) {
                subjectAdd.addSubject(subjectS.getName(), subjectS.getTime(), subjectS.getUsers().getLogin());
                if (SubjectAdd.FLAG_ADD_SUBJECT == true) {
                    message.setStatus("Successful");
                    message.setText("Предмет " + subjectS.getName() + " успешно добавлен");
                    return message;
                } else {
                    message.setStatus("Failed");
                    message.setText(SubjectAdd.TEXT_ERROR);
                    return message;
                }
            } else {
                message.setStatus("Failed");
                message.setText("Error signature");
                return message;
            }


        }


        @RequestMapping(value = "updatesubject", method = RequestMethod.POST, headers = {"Content-type=application/json"})
        @ResponseBody
        public Message updateUsers(@RequestBody SubjectS subjectS) throws SQLException, NoSuchAlgorithmException {
            Message message = new Message();
            UsersSelect usersSelect = new UsersSelect();
            SubjectUpdate subjectUpdate = new SubjectUpdate();
            SubjectSelect subjectSelect = new SubjectSelect();
            Subject id = subjectSelect.getSubject(subjectS.getId());
            if (subjectS.getSignature().equals(usersSelect.getUserHash(subjectS.getSignature()))) {
                if (id.getId() == subjectS.getId()) {
                    try {
                        subjectUpdate.subjectUpdate(subjectS);
                        message.setStatus("Successful");
                        message.setText("Объект успешно обновлен");
                    } catch (Exception e) {
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


        @RequestMapping(value = "deletesubject", method = RequestMethod.POST, headers = {"Content-type=application/json"})
        @ResponseBody
        public Message deleteSubject(@RequestBody SubjectS subjectS) throws SQLException, NoSuchAlgorithmException {
            Message message = new Message();
            UsersSelect userSelect = new UsersSelect();
            if (subjectS.getSignature().equals(userSelect.getUserHash(subjectS.getSignature()))) {
                SubjectSelect subjectSelect = new SubjectSelect();
                if (subjectSelect.getSubject(subjectS.getId()).getId() == subjectS.getId()) {
                    SubjectDelete subjectDeletel = new SubjectDelete();
                    subjectDeletel.deleteSubject(subjectS.getId());
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
