package com.example.jpahibernate.controller;

import com.example.jpahibernate.model.Project;
import com.example.jpahibernate.model.ProjectDev;
import com.example.jpahibernate.model.ProjectRes;
import com.example.jpahibernate.model.Task;
import com.example.jpahibernate.service.ProjectService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public void add(@RequestBody Project project) {
        this.projectService.addProject(project);
    }

    @GetMapping
    public List<Project> get() {
        return this.projectService.getProjects();
    }

    @GetMapping("/{id}")
    public ProjectDev get(@PathVariable(name = "id") long idProject) {
        return this.projectService.getProjectDevById(idProject);
    }

    @PutMapping
    public void update(@RequestBody Project project) {
        this.projectService.updateProject(project);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") long idProject) {
        this.projectService.deleteProject(idProject);
    }

    @GetMapping("/{id}/tasks")
    public List<Task> getTasksByProject(@PathVariable(name = "id") long idProject) {
        return this.projectService.getTasksByProject(idProject);
    }

    @PostMapping("/{id}/tasks")
    public void addTaskToProject(@PathVariable(name = "id") long idProject, @RequestBody Task task) {
        this.projectService.addTaskToProject(idProject, task);
    }

    @PostMapping("/dev")
    public void addProjectDev(@RequestBody ProjectDev projectDev) {
        this.projectService.addProject(projectDev);
    }

    @PostMapping("/res")
    public void addProjectRes(@RequestBody ProjectRes projectRes) {
        this.projectService.addProject(projectRes);
    }
}
