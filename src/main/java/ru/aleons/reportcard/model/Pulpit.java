package ru.aleons.reportcard.model;
public class Pulpit{

    private int numberPulpit;

    private String name;





    public Pulpit() {
    }

    public Pulpit(int numberPulpit, String name) {
        this.numberPulpit = numberPulpit;
        this.name = name;
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

    @Override
    public String toString() {
        return "Pulpit{" +
                "numberPulpit=" + numberPulpit +
                ", name='" + name + '\'' +
                '}';
    }
}
