package com.pairgood.todo;
import java.util.Date;

import com.pairgood.todo.repository.Status;
import com.pairgood.todo.repository.ToDo;
import com.pairgood.todo.repository.ToDoRepository;

import static org.apache.commons.lang.time.DateUtils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Date now = new Date(1645213932254L);
        toDoRepository.save(new ToDo(1,"Take out the garbage", addDays(now, 5), 5, Status.TODO, "bsmith", now, now));
        toDoRepository.save(new ToDo(2,"Wash the dishes", addDays(now, 10), 2, Status.DOING, "hjones", now, now));
        toDoRepository.save(new ToDo(3,"Fold the laundry", addDays(now, 2), 1, Status.TODO, "zloda", now, now));
        toDoRepository.save(new ToDo(4,"Feed the dog", addDays(now, 1), 3, Status.TODO, "bsmith", now, now));
        toDoRepository.save(new ToDo(5,"Winterize the house", addDays(now, 25), 7, Status.TODO, "hjones", now, now));
        toDoRepository.save(new ToDo(6,"Weed the garden", addDays(now, 100), 8, Status.DOING, "mwhite", now, now));
        toDoRepository.save(new ToDo(7,"Change the car oil", addDays(now, 7), 4, Status.DONE, "jbrown", now, now));
        toDoRepository.save(new ToDo(8,"File taxes", addDays(now, 3), 10, Status.TODO, "bsmith", now, now));
        toDoRepository.save(new ToDo(9,"Fix the gate", addMinutes(addDays(now, 2), 1), 6, Status.DOING, "jbrown", now, now));
        toDoRepository.save(new ToDo(10,"Renew your drivers license", addMinutes(addDays(now, 1), 1), 9, Status.TODO, "mwhite", now, now));
    }
    
}
