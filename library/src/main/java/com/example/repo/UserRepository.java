package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
}
