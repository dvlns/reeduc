package com.reeduc.ReeducSistema.repository;

import com.reeduc.ReeducSistema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
