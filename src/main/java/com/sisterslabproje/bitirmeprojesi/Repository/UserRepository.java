package com.sisterslabproje.bitirmeprojesi.Repository;


import com.sisterslabproje.bitirmeprojesi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
