package com.pairgood.owner.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OwnerRepository {

    private List<Owner> owners;

    public OwnerRepository(){
        owners = new ArrayList<>();
    }

    public void save(Owner owner){
        owners.add(owner);
    }

    public List<Owner> list(){
        Collections.sort(owners);
        return owners;
    }

    public Owner findById(long id) {
        return owners.stream()
                    .filter(owner -> id == (owner.getId()))
                    .findAny()
                    .orElse(null);
    }
}
