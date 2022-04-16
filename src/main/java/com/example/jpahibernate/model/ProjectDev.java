package com.example.jpahibernate.model;

import javax.persistence.Entity;

@Entity
public class ProjectDev extends Project {

    private String lang;

    public String getLang() {
        return lang;
    }

    public String setLang(String lang) {
        return this.lang = lang;
    }
}
