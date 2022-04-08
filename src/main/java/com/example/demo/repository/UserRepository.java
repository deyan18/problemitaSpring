package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Hero;
import com.example.demo.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> { 
    List<User> findByLastName(String lastName);
}
