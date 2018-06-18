package ru.aleons.reportcard.model;




public class Stud  {

    private int id;
    private String fio;
    private String contact;
    private Groups idGroups;


    public Stud() {
    }

    public Stud(int id) {
        this.id = id;
    }

    public Stud(String fio, String contact, Groups idGroups) {
        this.fio = fio;
        this.contact = contact;
        this.idGroups = idGroups;
    }

    public Stud(int id, String fio, String contact, Groups idGroups) {
        this.id = id;
        this.fio = fio;
        this.contact = contact;
        this.idGroups = idGroups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Groups getIdGroups() {
        return idGroups;
    }

    public void setIdGroups(Groups idGroups) {
        this.idGroups = idGroups;
    }
}
