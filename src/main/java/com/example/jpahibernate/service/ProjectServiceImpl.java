package com.example.jpahibernate.service;

import java.util.List;

import com.example.jpahibernate.model.Project;
import com.example.jpahibernate.model.ProjectDev;
import com.example.jpahibernate.model.Task;
import com.example.jpahibernate.repository.ProjectRepository;
import com.example.jpahibernate.repository.TaskRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepository projectRepo;
    @Autowired
    TaskRepo taskRepo;

    @Override
    public void addProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    @Override
    public ProjectDev getProjectDevById(long idProject) {
        return projectRepo.getProjectDevById(idProject);
    }

    @Override
    public void addTaskToProject(long idProject, Task task) {
        ProjectDev p = getProjectDevById(idProject);
        if (p != null) {
            task.setProject(p);
            taskRepo.save(task);
        }
    }

    @Override
    public List<Task> getTasksByProject(long idProject) {
        return projectRepo.getTasksByProject(idProject);
    }

    @Override
    public void updateProject(Project project) {
        Project p = projectRepo.getById(project.getIdProject());
        if (p != null) {
            p.setNom(project.getNom());
            p.setDescription(project.getDescription());
            projectRepo.save(p);
        }
    }

    @Override
    public void deleteProject(long idProject) {
        projectRepo.deleteById(idProject);
    }
    
}
