package com.checkoutsy.service.person.communication.controller;

import com.checkoutsy.service.person.communication.dto.PersonDto;
import com.checkoutsy.service.person.domain.model.Person;
import com.checkoutsy.service.person.domain.service.PersonService;
import com.checkoutsy.service.person.communication.mapper.PersonMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid final PersonDto personDto) {
        Person person = personMapper.toEntityForCreate(personDto);
        person = personService.create(person);

        PersonDto createdPersonDto = personMapper.toDto(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPersonDto);
    }

    @GetMapping("{personId}")
    public ResponseEntity<?> findById(@PathVariable final Long personId) {
        Person person = personService.findById(personId).orElse(null);
        if (person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        PersonDto dto = personMapper.toDto(person);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
