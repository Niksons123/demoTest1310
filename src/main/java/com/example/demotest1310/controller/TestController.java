package com.example.demotest1310.controller;


import com.example.demotest1310.dto.ResponsePersonDto;
import com.example.demotest1310.entity.Person;
import com.example.demotest1310.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private PersonService personService;
    @GetMapping
    public ResponseEntity<ResponsePersonDto> findByUsername(@RequestParam String username){
        Person person = personService.finByUsername(username);
        return new ResponseEntity<>(ResponsePersonDto.builder()
                .username(person.getUsername())
                .email(person.getEmail())
                .build(), HttpStatus.FOUND);
    }
    @PostMapping
    public ResponseEntity<ResponsePersonDto> save(@RequestBody Person person){
        Person save = personService.save(person);
        return new ResponseEntity<>(ResponsePersonDto.builder()
                .email(person.getEmail())
                .username(person.getUsername())
                .build(),HttpStatus.OK);
    }
}
