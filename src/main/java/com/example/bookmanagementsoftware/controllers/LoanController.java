package com.example.bookmanagementsoftware.controllers;

import com.example.bookmanagementsoftware.DTO.API;
import com.example.bookmanagementsoftware.model.Loan;
import com.example.bookmanagementsoftware.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoan(){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getAllLoan());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoan(id));

    }
    
    @PostMapping
    public ResponseEntity<API> addLoan(@RequestBody @Valid Loan loan){
        loanService.addLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New loan was added!", 201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<API> deleteLoan(@PathVariable Integer id){
        loanService.deleteLoan(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Loan was deleted!", 201));

    }
}
