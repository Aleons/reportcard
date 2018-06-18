package ru.aleons.reportcard.model.signature;

import ru.aleons.reportcard.model.Subject;

public class LabsS {
    private int id;
    private int numberLr;
    private String description;
    private Subject idSubject;
    String signature;

    public LabsS() {
    }

    public LabsS(int id, int numberLr, String description, Subject idSubject, String signature) {
        this.id = id;
        this.numberLr = numberLr;
        this.description = description;
        this.idSubject = idSubject;
        this.signature = signature;
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
