package com.pairgood.todo.controller;

import java.util.List;

import com.pairgood.todo.map.ToDoMapper;
import com.pairgood.todo.repository.ToDo;
import com.pairgood.todo.repository.ToDoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ToDoController {
    
    private final ToDoRepository toDoRepository;
    private final ToDoMapper toDoMapper;

    public ToDoController(ToDoRepository toDoRepository, ToDoMapper toDoMapper){
        this.toDoRepository = toDoRepository;
        this.toDoMapper = toDoMapper;
    }

    @GetMapping("/todos")
    public List<ToDoResponse> list(){
        List<ToDo> todos = toDoRepository.list();
        return toDoMapper.mapOwnerUsername(todos);
    }
}
