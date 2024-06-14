package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   @Query(value ="select * from users u where u.user_id = :id", nativeQuery = true )
   User findByUserId(@Param("id") long id);
}
