package com.example.jpahibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long idDeveloper;

    public String name;

    @Column(unique = true)
    public String email;

    @ManyToMany
    @JoinTable(
        name = "developer_task", 
        joinColumns = @JoinColumn(name = "id_developer"), 
        inverseJoinColumns = @JoinColumn(name = "id_task"))
    List<Task> tasks;

    public long getIdDeveloper() {
        return idDeveloper;
    }

    public void setIdDeveloper(long idDeveloper) {
        this.idDeveloper = idDeveloper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
