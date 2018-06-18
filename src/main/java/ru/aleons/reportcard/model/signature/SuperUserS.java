package ru.aleons.reportcard.model.signature;

public class SuperUserS {
    String oldLogin;
    String login;
    String password;
    String role;

    public SuperUserS() {
    }

    public SuperUserS(String oldLogin, String login, String password, String role) {
        this.oldLogin = oldLogin;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getOldLogin() {
        return oldLogin;
    }

    public void setOldLogin(String oldLogin) {
        this.oldLogin = oldLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
