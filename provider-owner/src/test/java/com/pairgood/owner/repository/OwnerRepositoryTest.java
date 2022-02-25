package com.pairgood.owner.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class OwnerRepositoryTest {

    @Test
    public void shouldSaveOwner(){
        Owner owner = new Owner(1, "", "", "");
        OwnerRepository repository = new OwnerRepository();

        repository.save(owner);

        List<Owner> owners = repository.list();
        assertEquals(1, owners.size());
        assertEquals(1, owners.get(0).getId());
    }
    
    @Test
    public void shouldFindAllOwners(){
        OwnerRepository repository = new OwnerRepository();
        Owner ownerFirst = new Owner(1, "", "", "");
        Owner ownerSecond = new Owner(2, "", "", "");
        Owner ownerThird = new Owner(3, "", "", "");
        Owner ownerFourth = new Owner(4, "", "", "");
        Owner ownerFifth = new Owner(5, "", "", "");

        repository.save(ownerFirst);
        repository.save(ownerSecond);
        repository.save(ownerThird);
        repository.save(ownerFourth);
        repository.save(ownerFifth);

        List<Owner> owners = repository.list();
        assertEquals(5, owners.size());
        assertEquals(1, owners.get(0).getId());
        assertEquals(2, owners.get(1).getId());
        assertEquals(3, owners.get(2).getId());
        assertEquals(4, owners.get(3).getId());
        assertEquals(5, owners.get(4).getId());
    }
}
