package com.pairgood.todo.repository;

import java.util.Date;

public class ToDo implements Comparable<ToDo>{

    private final Long id;
    private final String description;
    private final Date dueDate;
    private final int priority;
    private final Status status;
    private final Long ownerId;
    private final Date created;
    private final Date lastModified;

    public ToDo(long id, String description, Date dueDate, int priority, Status status, long ownerId, Date created,
            Date lastModified) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.ownerId = ownerId;
        this.created =created;
        this.lastModified = lastModified;
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

    public Long getOwnerId() {
        return ownerId;
    }
    
    public Date getCreated() {
        return created;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ToDo other = (ToDo) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int compareTo(ToDo other) {
        return id.compareTo(other.id);
    }
}
