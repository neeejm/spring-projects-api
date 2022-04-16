package com.example.jpahibernate.service;

import java.util.List;

import com.example.jpahibernate.model.Developer;
import com.example.jpahibernate.model.Task;
import com.example.jpahibernate.repository.DevRepo;
import com.example.jpahibernate.repository.TaskRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevServiceImpl implements DevService {
    @Autowired
    DevRepo devRepo;

    @Autowired
    TaskRepo taskRepo;

    @Override
    public void addDeveloper(Developer developer) {
        devRepo.save(developer);
    }

    @Override
    public void addTaskTodev(long idTask, long idDev) {
        Developer dev = devRepo.getById(idDev);
        Task task = taskRepo.getById(idTask);
        if (dev != null && task != null) {
            dev.getTasks().add(task);
            devRepo.save(dev);
        }
        
    }

    @Override
    public List<Developer> getDevelopers() {
        return devRepo.findAll();
    }

    @Override
    public Developer getDeveloperByEmail(String email) {
        return devRepo.findByEmail(email);
    }

    @Override
    public Developer getDeveloperById(long idDev) {
        return devRepo.findById(idDev).get();
    }

    @Override
    public void updateDeveloper(Developer developer) {
        Developer dev = devRepo.getById(developer.getIdDeveloper());
        if (dev != null)
            devRepo.save(dev);
    }

    @Override
    public void deleteDeveloper(long idDeveloper) {
        devRepo.deleteById(idDeveloper);
    }

    @Override
    public List<Developer> getDevelopersByIdProject(long idProject) {
        return devRepo.getDevs(idProject);
    }
}
