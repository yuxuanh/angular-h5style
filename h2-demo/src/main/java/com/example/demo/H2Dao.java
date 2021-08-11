package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface H2Dao extends CrudRepository<User,Long> {
    User findByName(String name);
    @Override
    Iterable<User> findAll();
    @Override
    void delete(User user);
}
