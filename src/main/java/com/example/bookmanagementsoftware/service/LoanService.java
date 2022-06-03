package com.example.bookmanagementsoftware.service;

import com.example.bookmanagementsoftware.exceptions.InvalidIdException;
import com.example.bookmanagementsoftware.exceptions.NoSuchFoundException;
import com.example.bookmanagementsoftware.model.Loan;
import com.example.bookmanagementsoftware.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    @RequiredArgsConstructor
    public class LoanService {

        private final LoanRepository loanRepository;

        public List<Loan> getAllLoan(){
            return loanRepository.findAll();
        }
        public void addLoan(Loan loan) {
            loanRepository.save(loan);
        }
    public Loan getLoan(Integer id) {
        Optional<Loan> loan = loanRepository.findById(id);
        if (loan.isPresent()){
            return loanRepository.findById(id).get();
        }else {
            throw new InvalidIdException("Invalid id");
        }
    }
    
    public void deleteLoan(Integer id) {
        Optional<Loan> loan = loanRepository.findById(id);
        if (loan.isPresent()){
            loanRepository.delete(loan.get());
        }
    }

    public List<Loan> getAllLoanByBook(Integer bookId) {
        List<Loan> loans = loanRepository.findAllByBookId(bookId);
        if (loans.size()<=0){
            throw new NoSuchFoundException("no loans found");
        }
       return loanRepository.findAllByBookId(bookId);
    }

//    public List<User> getLoanCustomer(Integer id) {
//        Optional<Loan> loan = loanRepository.findById(id);
//        if (loan.isPresent()){
//            return loan.get().getCustomers();
//        }else {
//            throw new InvalidIdException("No Customers for this loan id");
//        }
//    }
}