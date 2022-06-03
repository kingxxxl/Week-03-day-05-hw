package com.example.bookmanagementsoftware.repository;

import com.example.bookmanagementsoftware.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
