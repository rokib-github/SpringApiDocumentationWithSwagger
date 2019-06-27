package com.rokib.springApiDocumentationWithSwagger.persistence.repository;

import com.rokib.springApiDocumentationWithSwagger.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
