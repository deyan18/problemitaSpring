package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Hero;
import com.example.demo.entity.User;
import com.example.demo.repository.HeroRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heroes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HeroController {
    
    @Autowired
    HeroRepository heroRepo;

    @RequestMapping("")
    public ResponseEntity<Object> findHeroByName(@RequestParam(value = "name", required = false) String name) {
        List<Hero> heros = name!=null?heroRepo.findByNameContainingIgnoreCase(name):(List<Hero>) heroRepo.findAll();
        return ResponseEntity.ok(heros);
    }

    @PostMapping("")
    public Hero newHero(@RequestBody Hero hero) {
        return heroRepo.save(hero);
    }

    @PutMapping("")
    public Hero updateHero(@RequestBody Hero hero) {
        return heroRepo.save(hero);
    }

    @GetMapping("/{id}")
    public Hero getHeroByID(@PathVariable Long id) {
        return heroRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    void deleteHero(@PathVariable Long id) {
        heroRepo.deleteById(id);
    }
}
