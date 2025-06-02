package com.reeduc.ReeducSistema.controller;

import com.reeduc.ReeducSistema.model.Teacher;
import com.reeduc.ReeducSistema.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professores")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("professores", teacherService.getAllTeachers());
        return "professores/index";
    }

    @GetMapping("/cadastrar")
    public String createTeacher() {
        return "professores/cadastrar";
    }

    @PostMapping("/salvar")
    public String saveTeacher(@RequestParam String name, String cpf) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setCpf(cpf);
        teacherService.saveTeacher(teacher);
        return "redirect:/professores";
    }

    @GetMapping("/editar/{id}")
    public String exibirEditTeacher(@PathVariable Long id, Model model) {
        Teacher teacher = teacherService.getById(id);
        if (teacher == null) {
            return "redirect:/professores";
        }
        model.addAttribute("professor", teacher);
        return "professores/editar";
    }

    @PostMapping("/editar")
    public String editTeacher(@RequestParam Long id, @RequestParam String name, @RequestParam String cpf) {
        Teacher teacher = teacherService.getById(id);
        if (teacher != null) {
            teacher.setName(name);
            teacher.setCpf(cpf);
            teacherService.saveTeacher(teacher);
        }
        return "redirect:/professores";
    }

    @GetMapping("/excluir")
    public String deleteTeacher(@RequestParam Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/professores";
    }
}
