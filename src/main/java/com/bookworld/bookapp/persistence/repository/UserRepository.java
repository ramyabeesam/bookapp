package com.bookworld.bookapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookworld.bookapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
