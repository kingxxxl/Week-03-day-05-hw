package com.example.bookmanagementsoftware.service;

import com.example.bookmanagementsoftware.exceptions.InvalidIdException;
import com.example.bookmanagementsoftware.model.Book;
import com.example.bookmanagementsoftware.model.Loan;
import com.example.bookmanagementsoftware.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    @RequiredArgsConstructor
    public class BookService {

        private final BookRepository bookRepository;
        private final LoanService loanService;

        public List<Book> getAllBook(){
            return bookRepository.findAll();
        }
        public void addBook(Book book) {
            bookRepository.save(book);
        }
    public Book getBook(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            return bookRepository.findById(id).get();
        }else {
            throw new InvalidIdException("Invalid id");
        }
    }

    public void deleteBook(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            bookRepository.delete(book.get());
        }
    }

    public List<Loan> getBookLoan(Integer id) {

        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            return loanService.getAllLoanByBook(id);
        }else {
            throw new InvalidIdException("Invalid id");
        }
    }
}