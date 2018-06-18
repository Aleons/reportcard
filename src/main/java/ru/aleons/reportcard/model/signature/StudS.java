package ru.aleons.reportcard.model.signature;

import ru.aleons.reportcard.model.Groups;

public class StudS {
    private int id;
    private String fio;
    private String contact;
    private Groups idGroups;
    String signature;

    public StudS() {
    }

    public StudS(int id, String fio, String contact, Groups idGroups, String signature) {
        this.id = id;
        this.fio = fio;
        this.contact = contact;
        this.idGroups = idGroups;
        this.signature = signature;
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
