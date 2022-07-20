package com.melisaak.todos.entity.repository;


import com.melisaak.todos.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository sayesinde tüm CRUD işlemleri yapılabilir
@Repository
public interface ITodoRepository extends JpaRepository<TodoEntity,Long> {
}
