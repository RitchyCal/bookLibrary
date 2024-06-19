package com.example.repo;

import com.example.api.model.UserBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBooksRepository extends JpaRepository<UserBooks, Long> {
}
