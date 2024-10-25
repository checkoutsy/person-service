package com.checkoutsy.service.person.communication.mapper;

import com.checkoutsy.service.person.communication.dto.PersonDto;
import com.checkoutsy.service.person.domain.model.Person;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PersonMapper {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(14);

    public PersonDto toDto(Person person) {
        PersonDto dto = new PersonDto();

        dto.setId(person.getId());
        dto.setUsername(person.getUsername());
        dto.setEmail(person.getEmail());
        dto.setCreatedAt(person.getCreatedAt());
        dto.setUpdatedAt(person.getUpdatedAt());

        return dto;
    }

    public Person toEntityForCreate(PersonDto dto) {
        String plain = dto.getPassword();
        String hashed = passwordEncoder.encode(plain);

        Person person = new Person();

        person.setUsername(dto.getUsername());
        person.setPassword(hashed);
        person.setEmail(dto.getEmail());
        person.setCreatedAt(LocalDateTime.now());

        return person;
    }
}
