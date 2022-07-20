package com.melisaak.todos.business.services.impl;



import com.melisaak.todos.business.dto.TodoDto;
import com.melisaak.todos.business.services.ITodoServices;
import com.melisaak.todos.entity.TodoEntity;
import com.melisaak.todos.entity.repository.ITodoRepository;
import com.melisaak.todos.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class TodoServicesImpl implements ITodoServices {

    @Autowired
    ITodoRepository repository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public TodoDto entityToDto(TodoEntity todoEntity) {
        return modelMapper.map(todoEntity,TodoDto.class);
    }

    @Override
    public TodoEntity dtoToEntity(TodoDto todoDto) {
        return modelMapper.map(todoDto,TodoEntity.class);
    }

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        TodoEntity entity=  dtoToEntity(todoDto);
        repository.save(entity);
        return entityToDto(entity);
    }



    //LIST
    @Override
    public List<TodoDto> getAllTodos() {
        List<TodoEntity> listem= repository.findAll();
        List<TodoDto> dtoList = new ArrayList<>();
        for(TodoEntity entity   :listem){
            dtoList.add(entityToDto(entity));
        }
        return dtoList;
    }

    // FINDBYID
    // http://localhost:8080/find/todo/1
    @Override
    public TodoDto getTodoById(Long id) {
        TodoEntity entity= getEntityById(id);
        return entityToDto(entity);
    }

    // DELETE
    // http://localhost:8080/delete/todo/1
    @Override
    public void deleteTodo(Long id) {
        TodoEntity entity = getEntityById(id);
        repository.delete(entity);
    }

    // PUT(GÜNCELLEMEK)
    // http://localhost:8080/update/todo/1
    @Override
    public TodoDto updateTodo( Long id, TodoDto todoDto) {
        TodoEntity entityFind= getEntityById(id);
        entityFind.setTodoDescription(todoDto.getTodoDescription());
        TodoEntity saveEntity = repository.save(entityFind);
        return entityToDto(saveEntity);
    }


    private TodoEntity getEntityById(Long id){
        return repository.findById(id).orElseThrow( ()->new ResourceNotFoundException(id+"id'li  kayıt bulunamadı!"));
    }

}
