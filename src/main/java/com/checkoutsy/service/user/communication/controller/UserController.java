package com.checkoutsy.service.user.communication.controller;

import com.checkoutsy.service.user.communication.dto.UserDto;
import com.checkoutsy.service.user.domain.model.User;
import com.checkoutsy.service.user.domain.service.UserService;
import com.checkoutsy.service.user.mapping.UserMapper;
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
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid final UserDto userDto) {
        User user = userMapper.toEntityForCreate(userDto);
        user = userService.create(user);

        UserDto dto = userMapper.toDto(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable final Long id) {
        User user = userService.getById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        UserDto dto = userMapper.toDto(user);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
