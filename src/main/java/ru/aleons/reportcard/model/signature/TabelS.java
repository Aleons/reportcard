package ru.aleons.reportcard.model.signature;

import ru.aleons.reportcard.model.Labs;
import ru.aleons.reportcard.model.Stud;

public class TabelS {
    Stud idStud;
    Labs idLabs;
    int point;
    String date;
    String signature;
    Stud oldIdStud;
    Labs oldIdLabs;

    public TabelS() {
    }

    public TabelS(Stud idStud, Labs idLabs, int point, String date, String signature, Stud oldIdStud, Labs oldIdLabs) {
        this.idStud = idStud;
        this.idLabs = idLabs;
        this.point = point;
        this.date = date;
        this.signature = signature;
        this.oldIdStud = oldIdStud;
        this.oldIdLabs = oldIdLabs;
    }

    public Stud getIdStud() {
        return idStud;
    }

    public void setIdStud(Stud idStud) {
        this.idStud = idStud;
    }

    public Labs getIdLabs() {
        return idLabs;
    }

    public void setIdLabs(Labs idLabs) {
        this.idLabs = idLabs;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Labs getOldIdLabs() {
        return oldIdLabs;
    }

    public void setOldIdLabs(Labs oldIdLabs) {
        this.oldIdLabs = oldIdLabs;
    }
}
