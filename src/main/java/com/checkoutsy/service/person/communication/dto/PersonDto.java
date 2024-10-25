package com.checkoutsy.service.person.communication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

public class PersonDto {

    private Long id;

    @Size(min = 5, max = 20)
    private String username;

    @Email
    private String email;

    @Size(min = 8, max = 40)
    private String password;

    @Past
    private LocalDateTime createdAt;

    @Future
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(id, personDto.id)
                && Objects.equals(username, personDto.username)
                && Objects.equals(email, personDto.email)
                && Objects.equals(password, personDto.password)
                && Objects.equals(createdAt, personDto.createdAt)
                && Objects.equals(updatedAt, personDto.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, createdAt, updatedAt);
    }
}
