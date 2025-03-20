package com.example.onetoMany.controller;

import com.example.onetoMany.DTO.ProfessorDTO;
import com.example.onetoMany.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public ProfessorDTO getProfessorById(@PathVariable int id) {
        return professorService.getProfessorById(id);
    }

    @PostMapping
    public ProfessorDTO saveProfessor(@RequestBody ProfessorDTO professorDTO) {
        return professorService.saveProfessor(professorDTO);
    }
}
