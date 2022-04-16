package com.example.jpahibernate.service;

import java.util.List;

import com.example.jpahibernate.model.Project;
import com.example.jpahibernate.model.ProjectDev;
import com.example.jpahibernate.model.Task;

public interface ProjectService {
    void addProject(Project project);

    List<Project> getProjects();

    ProjectDev getProjectDevById(long idProject);

    void addTaskToProject(long idProject, Task task);

    List<Task> getTasksByProject(long idProject);

    void updateProject(Project project);

    void deleteProject(long idProject);
}