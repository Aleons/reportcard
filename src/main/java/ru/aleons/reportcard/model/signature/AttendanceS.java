package ru.aleons.reportcard.model.signature;

import ru.aleons.reportcard.model.Stud;
import ru.aleons.reportcard.model.Subject;

public class AttendanceS {
    Stud idStud;
    Subject idSubject;
    String date;
    boolean factOfPresence;
    String signature;
    Stud oldIdStud;
    Subject oldIdSubject;

    public AttendanceS() {
    }

    public AttendanceS(Stud idStud, Subject idSubject, String date, boolean factOfPresence, String signature, Stud oldIdStud, Subject oldIdSubject) {
        this.idStud = idStud;
        this.idSubject = idSubject;
        this.date = date;
        this.factOfPresence = factOfPresence;
        this.signature = signature;
        this.oldIdStud = oldIdStud;
        this.oldIdSubject = oldIdSubject;
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Stud getOldIdStud() {
        return oldIdStud;
    }

    public void setOldIdStud(Stud oldIdStud) {
        this.oldIdStud = oldIdStud;
    }

    public Subject getOldIdSubject() {
        return oldIdSubject;
    }

    public void setOldIdSubject(Subject oldIdSubject) {
        this.oldIdSubject = oldIdSubject;
    }
}
