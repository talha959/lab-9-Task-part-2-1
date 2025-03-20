package com.example.onetoMany.service;

import com.example.onetoMany.DTO.CourseDTO;
import com.example.onetoMany.DTO.ProfessorDTO;
import com.example.onetoMany.entities.Course;
import com.example.onetoMany.entities.Professor;
import com.example.onetoMany.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorById(int id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Professor not found with ID: " + id));
        return convertToDTO(professor);
    }

    public ProfessorDTO saveProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setName(professorDTO.getName());
        professor.setDepartment(professorDTO.getDepartment());

        List<Course> courses = professorDTO.getCourses().stream().map(courseDTO -> {
            Course course = new Course();
            course.setCourseName(courseDTO.getCourseName());
            course.setCreditHours(courseDTO.getCreditHours());
            course.setProfessor(professor);
            return course;
        }).collect(Collectors.toList());

        professor.setCourses(courses);
        return convertToDTO(professorRepository.save(professor));
    }

    private ProfessorDTO convertToDTO(Professor professor) {
        List<CourseDTO> courseDTOs = professor.getCourses().stream()
                .map(course -> new CourseDTO(course.getCourseId(), course.getCourseName(), course.getCreditHours()))
                .collect(Collectors.toList());

        return new ProfessorDTO(professor.getProfessorId(), professor.getName(), professor.getDepartment(), courseDTOs);
    }
}
