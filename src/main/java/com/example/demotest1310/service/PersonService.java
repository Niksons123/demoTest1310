package com.example.demotest1310.service;

import com.example.demotest1310.entity.Person;
import com.example.demotest1310.exception.UserNotFoundException;
import com.example.demotest1310.exception.UsernameIsAlreadyUsedException;
import com.example.demotest1310.repository.JpaPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private JpaPersonRepository jpaPersonRepository;

    public Person finByUsername(String username){
        return jpaPersonRepository.findByUsername(username).orElseThrow(()->
                new UserNotFoundException(String.format("Not found user %s", username)));
    }
    public Person save(Person person){
        if(jpaPersonRepository.existsByUsername(person.getUsername())){
            throw new UsernameIsAlreadyUsedException(String.format("User name is already used %s", person.getUsername()));
        }else {
            return jpaPersonRepository.save(person);
        }
    }
}
