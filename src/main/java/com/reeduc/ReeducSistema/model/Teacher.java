package com.reeduc.ReeducSistema.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String celular;
    private String genero;
    private String escolaridade;
    private String historico_profissional;
    private Date data_nascimento;
    private String email;
    private String nome_mae;
    private String nome_pai;
    private String estado_civil;
    private String local_nascimento;
    private Boolean possui_deficiencia;
    private String qual_deficiencia;

    @ManyToMany
    @JoinTable(
            name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();

    public Teacher() {
    }

    public Teacher(Long id, String name, String cpf, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.students = students;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
