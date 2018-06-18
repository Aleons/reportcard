package ru.aleons.reportcard.model.signature;

import ru.aleons.reportcard.model.Users;

public class SubjectS {
    private int id;
    private String name;
    private int time;
    private Users users;
    String signature;

    public SubjectS() {
    }

    public SubjectS(int id, String name, int time, Users users, String signature) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.users = users;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
