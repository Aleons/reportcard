package ru.aleons.reportcard.model.signature;

public class PulpitS {
    int oldNumberPulpit;
    int numberPulpit;
    String name;
    String signature;

    public PulpitS() {
    }

    public PulpitS(int oldNumberPulpit, int numberPulpit, String name, String signature) {
        this.oldNumberPulpit = oldNumberPulpit;
        this.numberPulpit = numberPulpit;
        this.name = name;
        this.signature = signature;
    }

    public int getOldNumberPulpit() {
        return oldNumberPulpit;
    }

    public void setOldNumberPulpit(int oldNumberPulpit) {
        this.oldNumberPulpit = oldNumberPulpit;
    }

    public int getNumberPulpit() {
        return numberPulpit;
    }

    public void setNumberPulpit(int numberPulpit) {
        this.numberPulpit = numberPulpit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
