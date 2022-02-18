package com.pairgood.todo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ToDoRepository {

    private List<ToDo> todos;

    public ToDoRepository(){
        todos = new ArrayList<>();
    }

    public void save(ToDo toDo){
        todos.add(toDo);
    }

    public List<ToDo> list(){
        Collections.sort(todos);
        return todos;
    }
}
