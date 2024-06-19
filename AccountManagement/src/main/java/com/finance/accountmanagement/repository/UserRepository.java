package com.finance.accountmanagement.repository;


import com.finance.accountmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findById(Long userId);

    User save(User user);

    void deleteById(Long userId);
    
    User findByUsername(String username);
}
