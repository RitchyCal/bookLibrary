package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   @Query(value = "select u from users where u.user_id = :user_id ",nativeQuery = true )
   Optional<User> findByUserid(@Param("user_id") long user_id);
}
