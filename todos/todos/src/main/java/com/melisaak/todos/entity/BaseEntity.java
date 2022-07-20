package com.melisaak.todos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//Lombok
@Data

//audit
@EntityListeners(AuditingEntityListener.class) // kim ekledi kim güncelledi görebilmek için audit kullanırız, Entity yapısını dinler
@JsonIgnoreProperties(value = {"created_date,update_date"}) // Bu verileri parse yapmaya gerek olmadığı için belirtiyoruz.

//super class oldugu için bunu gösterdik
@MappedSuperclass
//abstract yaptık new ile tekrar oluşturulmaması için
abstract  public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1 e 1 artan ve değiştirilemez olan
    @Column(name="todo_id",updatable = false)
    private Long todoId;

    @CreatedBy
    @Column(name="created_by")
    private String createdBy;

    @CreatedDate
    @Column(name="created_date")
    private Date creationDate;

    @LastModifiedBy
    @Column(name="update_by")
    private String updateBy;

    @LastModifiedDate
    @Column(name="update_date")
    private Date updateDate;
}
