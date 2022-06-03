package com.example.bookmanagementsoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor @RequiredArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    @NotNull(message ="name may not be empty" )
    private String  name;
    @NotNull(message ="genre may not be empty" )
    private String genre;

    @ManyToMany(mappedBy = "bookList")
   private List<Loan> loanList;

}
