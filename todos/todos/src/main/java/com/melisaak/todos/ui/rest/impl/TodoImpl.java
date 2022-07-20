package com.melisaak.todos.ui.rest.impl;


import com.melisaak.todos.business.dto.TodoDto;
import com.melisaak.todos.business.services.ITodoServices;
import com.melisaak.todos.ui.rest.ITodoRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")

public class TodoImpl implements ITodoRest {

    @Autowired
    ITodoServices services;

    //http://localhost:8080/api/v1/todo
    //http://localhost:8080/api/v1/index
    @GetMapping({"/","/index"})
    public String getRoot(){
        return "index";
    }

    //SAVE
    @Override
    @PostMapping("/todo")
    public TodoDto createTodo(@RequestBody TodoDto todoDto) {
        services.createTodo(todoDto);
        return todoDto;
    }

    @Override
    @GetMapping("/todo")
    public List<TodoDto> getAllTodos() {
        return services.getAllTodos();
    }

    //FIND
    @Override
    @GetMapping ({"/todo/{id}","/todo/"})
    public ResponseEntity<TodoDto> getTodoById(@PathVariable(name="id",required = false) Long id){
        TodoDto dto= services.getTodoById(id);
        return ResponseEntity.ok(dto);
    }

    //DELETE
    @Override
    @DeleteMapping({"/todo/{id}","/todo/"})
    public ResponseEntity<Void> deleteTodo(@PathVariable(name="id") Long id) {
        services.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    //UPDATE
    @Override
    @PostMapping("/todo/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable(name="id") Long id, @RequestBody TodoDto todoDto) {
        services.updateTodo(id,todoDto);
        return ResponseEntity.ok(todoDto);
    }
}
