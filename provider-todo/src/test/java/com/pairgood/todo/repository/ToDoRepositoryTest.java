package com.pairgood.todo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ToDoRepositoryTest {

    @Test
    public void shouldSaveToDo(){
        ToDo toDo = new ToDo(1, null, null, 0, null, 0, null, null);
        ToDoRepository repository = new ToDoRepository();

        repository.save(toDo);

        List<ToDo> todos = repository.list();
        assertEquals(1, todos.size());
        assertEquals(1, todos.get(0).getId());
    }
    
    @Test
    public void shouldFindAllToDos(){
        ToDoRepository repository = new ToDoRepository();
        ToDo toDoFirst = new ToDo(1, null, null, 0, null, 0, null, null);
        ToDo toDoSecond = new ToDo(2, null, null, 0, null, 0, null, null);
        ToDo toDoThird = new ToDo(3, null, null, 0, null, 0, null, null);
        ToDo toDoFourth = new ToDo(4, null, null, 0, null, 0, null, null);
        ToDo toDoFifth = new ToDo(5, null, null, 0, null, 0, null, null);

        repository.save(toDoFirst);
        repository.save(toDoSecond);
        repository.save(toDoThird);
        repository.save(toDoFourth);
        repository.save(toDoFifth);

        List<ToDo> todos = repository.list();
        assertEquals(5, todos.size());
        assertEquals(1, todos.get(0).getId());
        assertEquals(2, todos.get(1).getId());
        assertEquals(3, todos.get(2).getId());
        assertEquals(4, todos.get(3).getId());
        assertEquals(5, todos.get(4).getId());
    }
}
