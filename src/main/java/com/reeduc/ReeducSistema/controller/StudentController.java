package com.reeduc.ReeducSistema.controller;

import com.reeduc.ReeducSistema.model.Student;
import com.reeduc.ReeducSistema.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/estudantes")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("estudantes", studentService.getAllStudents());
        return "estudantes/index";
    }

    @GetMapping("/cadastrar")
    public String createStudent() {
        return "estudantes/cadastrar";
    }

    @PostMapping("/salvar")
    public String saveStudent(@RequestParam String name) {
        Student student = new Student();
        student.setName(name);
        studentService.saveStudent(student);
        return "redirect:/estudantes";
    }
}
