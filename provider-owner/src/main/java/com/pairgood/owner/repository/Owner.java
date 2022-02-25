package com.pairgood.owner.repository;

import java.util.Date;

public class Owner implements Comparable<Owner>{

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String username;

    public Owner(long id, String firstName, String lastName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Owner other = (Owner) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int compareTo(Owner other) {
        return id.compareTo(other.id);
    }
}
