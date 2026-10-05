package com.mentora.course_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length= 150)
    private String name;

    @Column(length = 20)
    private String code;

    @Column(length = 1000)
    private String description;

    @Column(name ="coordinator_id")
    private String coordinatorId;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Course(){

    }

    public Course(Long id, String name, String code, String description, String coordinatorId, LocalDateTime createdAT) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.coordinatorId = coordinatorId;
        this.createdAt = createdAT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(String coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public LocalDateTime getCreatedAT() {
        return createdAt;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAt = createdAT;
    }
}
