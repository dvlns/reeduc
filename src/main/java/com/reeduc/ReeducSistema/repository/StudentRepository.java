package com.reeduc.ReeducSistema.repository;

import com.reeduc.ReeducSistema.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
