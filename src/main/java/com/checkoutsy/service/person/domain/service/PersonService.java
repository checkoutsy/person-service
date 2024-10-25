package com.checkoutsy.service.person.domain.service;

import com.checkoutsy.service.person.domain.dao.PersonDao;
import com.checkoutsy.service.person.domain.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Transactional
    public Person create(final Person person) {
        return personDao.save(person);
    }

    public Optional<Person> findById(Long personId) {
        return personDao.findById(personId);
    }
}
