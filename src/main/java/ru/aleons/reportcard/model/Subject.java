package ru.aleons.reportcard.model;


public class Subject {

    private int id;
    private String name;
    private int time;
    private Users users;


    public Subject() {
    }

    public Subject(int id) {
        this.id = id;
    }

    public Subject(int id, String name, int time, Users users) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.users = users;
    }

    public Subject(String name, int time, Users users) {
        this.name = name;
        this.time = time;
        this.users = users;
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
}
