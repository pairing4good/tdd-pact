package com.pairgood.owner;

import com.pairgood.owner.repository.Owner;
import com.pairgood.owner.repository.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    private OwnerRepository toDoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        toDoRepository.save(new Owner(1,"Brad", "Smith", "bsmith"));
        toDoRepository.save(new Owner(2,"Horatio", "Jones", "hjones"));
        toDoRepository.save(new Owner(3,"Zilpah", "Loda", "zloda"));
        toDoRepository.save(new Owner(4,"Marcus", "White", "mwhite"));
        toDoRepository.save(new Owner(5,"Jose", "Brown", "jbrown"));
    }
    
}
