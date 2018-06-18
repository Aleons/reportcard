package ru.aleons.reportcard.model;
public class Groups{
    private int id;
    private String nameGroups;
    private Pulpit numberPulpit;
    private Users user;

    public Groups() {
    }


    public Groups(String nameGroups, Pulpit numberPulpit, Users user) {

        this.nameGroups = nameGroups;
        this.numberPulpit = numberPulpit;
        this.user = user;

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

    public Users getuser() {
        return user;
    }

    public void setuser(Users superuser) {
        this.user = superuser;
    }
}
