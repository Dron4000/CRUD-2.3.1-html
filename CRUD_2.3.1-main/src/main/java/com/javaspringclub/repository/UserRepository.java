package com.javaspringclub.repository;

import com.javaspringclub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository  extends JpaRepository<User,Integer> {


    @Query("SELECT u  FROM User  u WHERE  u.username = :username")
   User findByUsername(@Param("username") String username);
//
//  Optional<User> findById(@Param("id") Long id);
//


}
