package com.example.bookmanagementsoftware.repository;

import com.example.bookmanagementsoftware.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
