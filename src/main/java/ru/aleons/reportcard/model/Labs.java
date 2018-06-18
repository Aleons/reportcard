package ru.aleons.reportcard.model;


public class Labs{

    private int id;
    private int numberLr;
    private String description;
    private Subject idSubject;

    public Labs() {
    }

    public Labs(int id) {
        this.id = id;
    }

    public Labs(int id, int numberLr, String description, Subject idSubject) {
        this.id = id;
        this.numberLr = numberLr;
        this.description = description;
        this.idSubject = idSubject;
    }

    public Labs(int numberLr, String description, Subject idSubject) {
        this.numberLr = numberLr;
        this.description = description;
        this.idSubject = idSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberLr() {
        return numberLr;
    }

    public void setNumberLr(int numberLr) {
        this.numberLr = numberLr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Subject idSubject) {
        this.idSubject = idSubject;
    }
}
