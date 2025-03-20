package com.example.onetoMany.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;
    private String name;
    private String department;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

    // Constructors, Getters, and Setters
    public Professor() {}

    public Professor(String name, String department, List<Course> courses) {
        this.name = name;
        this.department = department;
        this.courses = courses;
    }

    public int getProfessorId() { return professorId; }
    public void setProfessorId(int professorId) { this.professorId = professorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
        for (Course course : courses) {
            course.setProfessor(this);
        }
    }
}
