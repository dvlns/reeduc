package com.reeduc.ReeducSistema.controller;

import com.reeduc.ReeducSistema.model.Student;
import com.reeduc.ReeducSistema.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String saveStudent(@RequestParam String name, String cpf) {
        Student student = new Student();
        student.setName(name);
        student.setCpf(cpf);
        studentService.saveStudent(student);
        return "redirect:/estudantes";
    }

    @GetMapping("/editar/{id}")
    public String exibirEditStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getById(id);
        if (student == null) {
            return "redirect:/estudantes";
        }
        model.addAttribute("estudante", student);
        return "estudantes/editar";
    }

    @PostMapping("/editar")
    public String editStudent(@RequestParam Long id, @RequestParam String name, @RequestParam String cpf) {
        Student student = studentService.getById(id);
        if (student != null) {
            student.setName(name);
            student.setCpf(cpf);
            studentService.saveStudent(student);
        }
        return "redirect:/estudantes";
    }

    @GetMapping("/excluir")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/estudantes";
    }
}
