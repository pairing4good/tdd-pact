package com.pairgood.todo.controller;

import java.util.List;

import com.pairgood.todo.repository.ToDo;
import com.pairgood.todo.repository.ToDoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ToDoController {
    
    private ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todos")
    public List<ToDo> list(){
        return toDoRepository.list();
    }
}
