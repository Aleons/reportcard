package ru.aleons.reportcard.model;




public class Users {

    private String login;
    private String pass;
    private String fio;
    private String academicDegree;
    int numberPulpit;

    public Users() {
    }

    public Users(String login, String pass, String fio, String academicDegree, int numberPulpit) {
        this.login = login;
        this.pass = pass;
        this.fio = fio;
        this.academicDegree = academicDegree;
        this.numberPulpit = numberPulpit;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public int getNumberPulpit() {
        return numberPulpit;
    }

    public void setNumberPulpit(int numberPulpit) {
        this.numberPulpit = numberPulpit;
    }
}