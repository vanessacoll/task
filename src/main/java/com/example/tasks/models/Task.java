package com.example.tasks.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


public class Task {

    private Integer id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    public Task() {}

    public Task(String name, String description, Date startDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
