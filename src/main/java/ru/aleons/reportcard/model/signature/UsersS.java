package ru.aleons.reportcard.model.signature;

public class UsersS {
    String oldLogin;
    String login;
    String pass;
    String fio;
    String academicDegree;
    int numberPulpit;
    String signature;

    public UsersS(String oldLogin, String login, String pass, String fio, String academicDegree, int numberPulpit, String signature) {
        this.oldLogin = oldLogin;
        this.login = login;
        this.pass = pass;
        this.fio = fio;
        this.academicDegree = academicDegree;
        this.numberPulpit = numberPulpit;
        this.signature = signature;
    }

    public String getOldLogin() {
        return oldLogin;
    }

    public void setOldLogin(String oldLogin) {
        this.oldLogin = oldLogin;
    }



    public int getNumberPulpit() {
        return numberPulpit;
    }

    public void setNumberPulpit(int numberPulpit) {
        this.numberPulpit = numberPulpit;
    }

    public UsersS(String login, String pass, String fio, String academicDegree, int numberPulpit, String signature) {

        this.login = login;
        this.pass = pass;
        this.fio = fio;
        this.academicDegree = academicDegree;
        this.numberPulpit = numberPulpit;
        this.signature = signature;
    }



    public UsersS() {
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
