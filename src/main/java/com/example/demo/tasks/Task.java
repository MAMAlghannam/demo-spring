package com.example.demo.tasks;

import java.util.Date;

public class Task{

    private String content;
    private boolean isDone;
    private Date date;

    public Task(String content, boolean isDone){
        this.content = content;
        this.isDone = isDone;
        this.date = new Date();
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
}
