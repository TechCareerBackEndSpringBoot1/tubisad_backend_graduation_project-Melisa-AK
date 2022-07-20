package com.melisaak.todos.ui.rest;



import com.melisaak.todos.business.dto.TodoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITodoRest {

    //SAVE
    TodoDto createTodo(TodoDto todoDto);

    //LIST
    List<TodoDto> getAllTodos();

    //FIND
    ResponseEntity<TodoDto> getTodoById(Long id);

    //DELETE
    ResponseEntity<Void> deleteTodo(Long id);

    //UPDATE
    ResponseEntity<TodoDto> updateTodo(Long id, TodoDto todoDto);
}
