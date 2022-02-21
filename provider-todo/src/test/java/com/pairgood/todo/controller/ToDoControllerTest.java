package com.pairgood.todo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.pairgood.todo.repository.ToDo;
import com.pairgood.todo.repository.ToDoRepository;

import org.junit.jupiter.api.Test;

public class ToDoControllerTest {

    @Test
    public void shouldListAllToDos(){
        ToDoController controller = new ToDoController(new FakeToDoRepository());

        List<ToDo> todos = controller.list();

        assertEquals(3, todos.size());
        assertEquals(1, todos.get(0).getId());
        assertEquals(2, todos.get(1).getId());
        assertEquals(3, todos.get(2).getId());
    }
    
}

class FakeToDoRepository extends ToDoRepository{

    private List<ToDo> todos;

    public FakeToDoRepository(){
        todos = new ArrayList();
        todos.add(new ToDo(1, null, null, 0, null, null, null, null ));
        todos.add(new ToDo(2, null, null, 0, null, null, null, null ));
        todos.add(new ToDo(3, null, null, 0, null, null, null, null ));
    }
    @Override
    public List<ToDo> list() {
        return todos;
    }
}