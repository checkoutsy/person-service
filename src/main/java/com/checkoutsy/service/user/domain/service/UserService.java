package com.checkoutsy.service.user.domain.service;

import com.checkoutsy.service.user.domain.dao.UserDao;
import com.checkoutsy.service.user.domain.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User create(final User user) {
        return userDao.save(user);
    }

    public Optional<User> getById(Long id) {
        return userDao.findById(id);
    }
}
