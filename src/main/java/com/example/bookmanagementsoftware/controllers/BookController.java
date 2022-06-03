package com.example.bookmanagementsoftware.controllers;

import com.example.bookmanagementsoftware.DTO.API;
import com.example.bookmanagementsoftware.model.Book;
import com.example.bookmanagementsoftware.model.Loan;
import com.example.bookmanagementsoftware.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBook(id));

    }

    @GetMapping("loan/{id}")
    public ResponseEntity<List<Loan>> getBookLoan(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookLoan(id));

    }
    
    @PostMapping
    public ResponseEntity<API> addBook(@RequestBody @Valid Book book){
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New book was added!", 201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<API> deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Book was deleted!", 201));

    }
}
