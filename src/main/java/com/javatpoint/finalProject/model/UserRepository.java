package com.javatpoint.finalProject.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select a from User a where a.username= :username")
    User findByUsername(@Param("username") String username);
}