package com.example.jpahibernate.repository;

import com.example.jpahibernate.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
