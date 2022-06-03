package com.example.bookmanagementsoftware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@AllArgsConstructor @RequiredArgsConstructor
@Data
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    @Positive
    @NotNull(message ="userId may not be empty" )
    private Integer  userId;
    @NotNull(message ="bookId may not be empty" )
    private Integer  bookId;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "BOOK_LOAN",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "LOAN_ID")
    )
    @JsonIgnore
    List<Book> bookList;

}
