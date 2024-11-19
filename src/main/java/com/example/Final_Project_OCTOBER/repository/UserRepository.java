package com.example.Final_Project_OCTOBER.repository;

import com.example.Final_Project_OCTOBER.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.email=:email")
    User findByEmail(String email);

}
