package com.example.jpahibernate.model;

import javax.persistence.Entity;

@Entity
public class ProjectRes extends Project {

    private double budget;

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

}