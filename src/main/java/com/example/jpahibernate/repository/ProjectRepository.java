package com.example.jpahibernate.repository;

import java.util.List;

import com.example.jpahibernate.model.Project;
import com.example.jpahibernate.model.ProjectDev;
import com.example.jpahibernate.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "select t from Task t where t.projectDev.idProject = :idProjectDev")
    List<Task> getTasksByProject(@Param("idProjectDev") long idProjectDev);

    @Query("select p from ProjectDev p")
    List<ProjectDev> getProjectDevs();

    @Query("select p from ProjectDev p where p.idProject = :idProject")
    ProjectDev getProjectDevById(@Param("idProject") long idProject);
}
