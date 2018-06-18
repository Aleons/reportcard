package ru.aleons.reportcard.model.signature;

import ru.aleons.reportcard.model.Pulpit;
import ru.aleons.reportcard.model.Users;

public class GroupsS {
    private int id;
    private String nameGroups;
    private Pulpit numberPulpit;
    private Users users;
    String signature;
    String oldName;

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public GroupsS(int id, String nameGroups, Pulpit numberPulpit, Users users, String signature, String oldName) {

        this.id = id;
        this.nameGroups = nameGroups;
        this.numberPulpit = numberPulpit;
        this.users = users;
        this.signature = signature;
        this.oldName = oldName;
    }

    public GroupsS() {
    }

    public GroupsS(int id, String nameGroups, Pulpit numberPulpit, Users users, String signature) {
        this.id = id;
        this.nameGroups = nameGroups;
        this.numberPulpit = numberPulpit;
        this.users = users;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGroups() {
        return nameGroups;
    }

    public void setNameGroups(String nameGroups) {
        this.nameGroups = nameGroups;
    }

    public Pulpit getNumberPulpit() {
        return numberPulpit;
    }

    public void setNumberPulpit(Pulpit numberPulpit) {
        this.numberPulpit = numberPulpit;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
