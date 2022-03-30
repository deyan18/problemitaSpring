package com.example.demo.repository;

import com.example.demo.entity.Superpower;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface SuperpowerRepository extends CrudRepository<Superpower, Long> { 

}
