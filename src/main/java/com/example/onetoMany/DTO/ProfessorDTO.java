package com.example.onetoMany.DTO;

import java.util.List;

public class ProfessorDTO {
    private int professorId;
    private String name;
    private String department;
    private List<CourseDTO> courses;

    // Constructors
    public ProfessorDTO() {}

    public ProfessorDTO(int professorId, String name, String department, List<CourseDTO> courses) {
        this.professorId = professorId;
        this.name = name;
        this.department = department;
        this.courses = courses;
    }

    // Getters & Setters
    public int getProfessorId() { return professorId; }
    public void setProfessorId(int professorId) { this.professorId = professorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<CourseDTO> getCourses() { return courses; }
    public void setCourses(List<CourseDTO> courses) { this.courses = courses; }
}
