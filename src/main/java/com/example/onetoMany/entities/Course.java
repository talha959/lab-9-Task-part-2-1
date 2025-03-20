package com.example.onetoMany.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private int creditHours;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    // Constructors, Getters, and Setters
    public Course() {}

    public Course(String courseName, int creditHours, Professor professor) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.professor = professor;
    }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCreditHours() { return creditHours; }
    public void setCreditHours(int creditHours) { this.creditHours = creditHours; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
}
