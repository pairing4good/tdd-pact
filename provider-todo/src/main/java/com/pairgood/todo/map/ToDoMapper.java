package com.pairgood.todo.map;

import java.util.ArrayList;
import java.util.List;

import com.pairgood.todo.controller.ToDoResponse;
import com.pairgood.todo.repository.ToDo;
import com.pairgood.todo.service.Owner;
import com.pairgood.todo.service.OwnerService;

import org.springframework.stereotype.Component;

@Component
public class ToDoMapper {

    private final OwnerService ownerService;

    public ToDoMapper(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    public List<ToDoResponse> mapOwnerUsername(List<ToDo> todos){
        List<ToDoResponse> responses = new ArrayList();

        for(ToDo todo : todos){
            Long ownerId = todo.getOwnerId();
            Owner owner = ownerService.findById(ownerId);

            ToDoResponse toDoResponse = new ToDoResponse(todo.getId(), todo.getDescription(), todo.getDueDate(), owner.getUsername(), todo.getCreated());
            responses.add(toDoResponse);
        }

        return responses;
    }
}
