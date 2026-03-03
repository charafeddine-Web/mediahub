package com.ilyassan.mediahub.user.repository;

import com.ilyassan.mediahub.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository<User, Long>:
//   - User  = the entity this repository manages
//   - Long  = the type of the primary key (@Id)
// Spring Data auto-generates the SQL for all basic operations (findAll, save, deleteById, etc.)
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data reads the method name and generates: SELECT * FROM users WHERE email = ?
    Optional<User> findByEmail(String email);
}
