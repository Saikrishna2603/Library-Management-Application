package com.Management.LibraryManagementApplication.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String author;
    private boolean borrowed;
    @ManyToOne
    //We added a relationship between the Book and User entities to track which user has borrowed a book.
    @JoinColumn(name="user_id")
    private User borrowedBy;
}
