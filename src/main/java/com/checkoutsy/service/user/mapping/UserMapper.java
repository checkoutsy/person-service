package com.checkoutsy.service.user.mapping;

import com.checkoutsy.service.user.communication.dto.UserDto;
import com.checkoutsy.service.user.domain.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(14);

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        return dto;
    }

    public User toEntityForCreate(UserDto dto) {
        String plain = dto.getPassword();
        String hashed = passwordEncoder.encode(plain);

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(hashed);
        user.setEmail(dto.getEmail());
        user.setCreatedAt(LocalDateTime.now());

        return user;
    }
}
