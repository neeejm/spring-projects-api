package com.example.jpahibernate.controller;

import java.util.List;

import com.example.jpahibernate.model.Developer;
import com.example.jpahibernate.service.DevService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devs")
public class DevController {
    @Autowired
    private DevService devService;

    @GetMapping
    public List<Developer> get() {
        return this.devService.getDevelopers();
    }

    @GetMapping("/{id}")
    public Developer get(@PathVariable(name = "id") long idDev) {
        return this.devService.getDeveloperById(idDev);
    }

    @GetMapping("/projects/{id}")
    public List<Developer> getByProject(@PathVariable(name = "id") long idProject) {
        return this.devService.getDevelopersByIdProject(idProject);
    }
    

    @PostMapping
    public void add(@RequestBody Developer developer) {
        this.devService.addDeveloper(developer);
    }

    @PostMapping("/{id}/{idTask}")
    public void addTaskTodev(@PathVariable(name = "id") long idDev, @PathVariable(name = "idTask") long idTask) {
        this.devService.addTaskTodev(idTask, idDev);
    }
}
