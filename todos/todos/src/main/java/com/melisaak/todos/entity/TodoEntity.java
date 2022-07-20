package com.melisaak.todos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "todo")
// BaseEntity deki verileri kullanacağından extends ile ekledik!
public class TodoEntity extends BaseEntity {
    private String todoDescription;
    private boolean completed;

}

