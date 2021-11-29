package com.javaspringclub.repository;

import com.javaspringclub.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User,Long> {


@Query("SELECT u  FROM User  u WHERE  u.username = :username")
    User getUserByName(@Param("username") String username);


}
