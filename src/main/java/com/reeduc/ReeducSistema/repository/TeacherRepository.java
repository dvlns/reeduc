package com.reeduc.ReeducSistema.repository;

import com.reeduc.ReeducSistema.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}