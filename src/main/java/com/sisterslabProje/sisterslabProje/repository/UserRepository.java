package com.sisterslabProje.sisterslabProje.repository;

import com.sisterslabProje.sisterslabProje.model.Movie;
import com.sisterslabProje.sisterslabProje.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
