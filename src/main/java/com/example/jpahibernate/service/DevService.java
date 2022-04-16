package com.example.jpahibernate.service;

import java.util.List;

import com.example.jpahibernate.model.Developer;

public interface DevService {
    void addDeveloper(Developer developer);

    void addTaskTodev(long idTask, long idDev);

    List<Developer> getDevelopers();

    Developer getDeveloperByEmail(String email);

    Developer getDeveloperById(long idDev);

    void updateDeveloper(Developer developer);

    void deleteDeveloper(long idDeveloper);
    
    List<Developer> getDevelopersByIdProject(long idProject);
}
