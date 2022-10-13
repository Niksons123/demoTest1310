package com.example.demotest1310.repository;


import com.example.demotest1310.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByUsername(String username);

    boolean existsByUsername(String username);
}
