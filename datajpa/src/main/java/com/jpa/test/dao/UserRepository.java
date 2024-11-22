package com.jpa.test.dao;

import com.jpa.test.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByName(String name);

    @Query("select u from User u")
    public List<User> getAllUsers();
}
