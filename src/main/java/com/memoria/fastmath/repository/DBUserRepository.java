package com.memoria.fastmath.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memoria.fastmath.model.DBUser;

public interface DBUserRepository extends JpaRepository<DBUser, Integer> {

    public DBUser findByUsername(String username);
}