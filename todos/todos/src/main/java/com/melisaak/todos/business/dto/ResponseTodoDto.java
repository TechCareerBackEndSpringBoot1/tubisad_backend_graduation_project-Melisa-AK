package com.melisaak.todos.business.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ResponseTodoDto {
    private Long todoId;
    private String todoDescription;
}
