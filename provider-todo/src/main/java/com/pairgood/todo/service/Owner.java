package com.pairgood.todo.service;


public class Owner{

    private Long id;
    private String username;

    public Owner(Long id, String username){
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
