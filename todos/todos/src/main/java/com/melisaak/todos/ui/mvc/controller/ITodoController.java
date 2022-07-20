package com.melisaak.todos.ui.mvc.controller;



import com.melisaak.todos.business.dto.ResponseTodoDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface ITodoController {

    //SpeedDataInsert
    public String speedDataInsert();

    //SAVE
    public String todoControllerSaveGetForm(Model model);
    public String todoControllerSavePostForm(ResponseTodoDto responseTodoDto, BindingResult bindingResult);

    //LIST
    public String todoControllerList(Model model);

    //FIND
    public String todoControllerFind( Long id,  Model model);


    //DELETE
    public String todoControllerDelete( Long id,  Model model);

    //UPDATE
    public String todoControllerUpdateGetForm(Long id,Model model);
    public String todoControllerUpdatePostForm(ResponseTodoDto responseTodoDto, Long id, BindingResult bindingResult);



}
