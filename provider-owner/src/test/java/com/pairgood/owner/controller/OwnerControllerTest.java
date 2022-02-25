package com.pairgood.owner.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pairgood.owner.repository.Owner;
import com.pairgood.owner.repository.OwnerRepository;

import org.junit.jupiter.api.Test;

public class OwnerControllerTest {

    @Test
    public void shouldListAllOwners(){
        OwnerController controller = new OwnerController(new FakeOwnerRepository());

        Owner owner = controller.byID(1);

        assertEquals(1, owner.getId());
    }
    
}

class FakeOwnerRepository extends OwnerRepository{

    @Override
    public Owner findById(long id) {
        return new Owner(id, "", "", "");
    }

}