package com.hiba.stage.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hiba.stage.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
