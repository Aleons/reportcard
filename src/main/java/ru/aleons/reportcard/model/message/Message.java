package ru.aleons.reportcard.model.message;

public class Message {
    String status;
    String text;

    public Message() {
    }

    public Message(String status, String text) {
        this.status = status;
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
