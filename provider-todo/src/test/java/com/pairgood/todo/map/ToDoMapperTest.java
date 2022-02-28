package com.pairgood.todo.map;

import com.pairgood.todo.controller.ToDoResponse;
import com.pairgood.todo.repository.ToDo;
import com.pairgood.todo.service.Owner;
import com.pairgood.todo.service.OwnerService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoMapperTest {

    @Test
    public void shouldMapOwnerOntoToDo(){
        List<ToDo> todos = Arrays.asList(
                new ToDo(1, null, null, 0, null, 1, null, null),
                new ToDo(2, null, null, 0, null, 2, null, null),
                new ToDo(3, null, null, 0, null, 3, null, null)
        );

        ToDoMapper mapper = new ToDoMapper(new FakeOwnerService("testUrl"));
        List<ToDoResponse> toDoResponses = mapper.mapOwnerUsername(todos);

        assertEquals(3, toDoResponses.size());

        assertEquals(1, toDoResponses.get(0).getId());
        assertEquals("test1", toDoResponses.get(0).getOwner());

        assertEquals(2, toDoResponses.get(1).getId());
        assertEquals("test2", toDoResponses.get(1).getOwner());

        assertEquals(3, toDoResponses.get(2).getId());
        assertEquals("test3", toDoResponses.get(2).getOwner());
    }
}

class FakeOwnerService extends OwnerService {

    public FakeOwnerService(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public Owner findById(long id) {
        return new Owner(id, "test" + id);
    }
}