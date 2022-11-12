package com.example.demo.scheduler;

public class Appointment {

    private String at;
    private String username;

    public Appointment(String at, String username){
        this.at = at;
        this.username = username;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAt() {
        return at;
    }

    public String getUsername() {
        return username;
    }
    
}
