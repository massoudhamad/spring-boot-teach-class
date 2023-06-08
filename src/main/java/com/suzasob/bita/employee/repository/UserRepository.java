package com.suzasob.bita.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suzasob.bita.employee.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
