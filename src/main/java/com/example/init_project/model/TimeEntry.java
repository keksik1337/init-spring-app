package com.example.init_project.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "time_entry")
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String systemTime;

    public TimeEntry() {

    }

    public TimeEntry(String systemTime) {
        this.systemTime = systemTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }
}
