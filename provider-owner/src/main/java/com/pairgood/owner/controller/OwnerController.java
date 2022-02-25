package com.pairgood.owner.controller;

import com.pairgood.owner.repository.Owner;
import com.pairgood.owner.repository.OwnerRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OwnerController {
    
    private OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/owners/{id}")
    public Owner byID(@PathVariable("id") long id){
        Owner owner = ownerRepository.findById(id);

        if(owner == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return owner;
    }
}
