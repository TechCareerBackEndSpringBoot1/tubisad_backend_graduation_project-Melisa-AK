package com.melisaak.todos.business.services;


import com.melisaak.todos.business.dto.TodoDto;
import com.melisaak.todos.entity.TodoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITodoServices {

    //Model Mapper
    public TodoDto entityToDto(TodoEntity todoEntity);
    public TodoEntity  dtoToEntity(TodoDto todoDto);

    //save
    public TodoDto createTodo(TodoDto todoDto);

    //list
    public List<TodoDto> getAllTodos();

    //find
    public TodoDto getTodoById(Long id);

    //delete
    public void  deleteTodo(Long id);

    //update
    public TodoDto updateTodo(Long id,TodoDto todoDto);
}
