package ru.aleons.reportcard.model;

public class Attendance {
    Stud idStud;
    Subject idSubject;
    String date;
    boolean factOfPresence;

    public Attendance() {
    }


    public Attendance(Stud idStud, Subject idSubject, String date, boolean factOfPresence) {
        this.idStud = idStud;
        this.idSubject = idSubject;
        this.date = date;
        this.factOfPresence = factOfPresence;
    }

    public Stud getIdStud() {
        return idStud;
    }

    public void setIdStud(Stud idStud) {
        this.idStud = idStud;
    }

    public Subject getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Subject idSubject) {
        this.idSubject = idSubject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getFactOfPresence() {
        return factOfPresence;
    }

    public void setFactOfPresence(boolean factOfPresence) {
        this.factOfPresence = factOfPresence;
    }
}
