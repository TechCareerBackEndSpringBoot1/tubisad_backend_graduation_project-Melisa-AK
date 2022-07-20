package com.melisaak.todos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//İstenilen veri bulunamadığı takdirde dönecek kendi excepitonımızı  oluşturduk
@ResponseStatus(value = HttpStatus.NOT_FOUND) //Böyle bir kaynak yoktur!
public class ResourceNotFoundException extends RuntimeException{

    //parametreli constructor
    public  ResourceNotFoundException(String message){
        super(message);
    }
}
