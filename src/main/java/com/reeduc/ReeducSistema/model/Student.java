package com.reeduc.ReeducSistema.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private Integer rji;
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
    private Set<Teacher> teachers = new HashSet<>();

    public Student() {
    }

    public Student(Long id, String name, String cpf, Set<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.teachers = teachers;
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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
