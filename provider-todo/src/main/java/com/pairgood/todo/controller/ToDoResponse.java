package com.pairgood.todo.controller;

import java.util.Date;

public class ToDoResponse {
    
    private final Long id;
    private final String description;
    private final Date dueDate;
    private final String owner;
    private final Date created;

    public ToDoResponse(long id, String description, Date dueDate, String owner, Date created) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.owner = owner;
        this.created =created;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getOwner() {
        return owner;
    }
    
    public Date getCreated() {
        return created;
    }
}
