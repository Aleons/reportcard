package ru.aleons.reportcard.model;

public class Tabel {
    Stud idStud;
    Labs idLabs;
    int point;
    String date;


    public Tabel() {
    }

    public Tabel(Stud idStud, Labs idLabs, int point, String date) {
        this.idStud = idStud;
        this.idLabs = idLabs;
        this.point = point;
        this.date = date;
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
}
