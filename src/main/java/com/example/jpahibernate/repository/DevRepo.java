package com.example.jpahibernate.repository;

import java.util.List;

import com.example.jpahibernate.model.Developer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DevRepo extends JpaRepository<Developer, Long> {
    Developer findByEmail(String email);

    @Query("select d from Developer d join d.tasks t where t.projectDev.idProject = :idProject")
    List<Developer> getDevs(@Param("idProject") long idProject);
}
