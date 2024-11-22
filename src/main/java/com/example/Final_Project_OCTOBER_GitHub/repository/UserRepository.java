package com.example.Final_Project_OCTOBER_GitHub.repository;

import com.example.Final_Project_OCTOBER_GitHub.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.email=:email")
    User findByEmail(String email);

}
