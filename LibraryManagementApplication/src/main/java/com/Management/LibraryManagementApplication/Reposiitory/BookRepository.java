package com.Management.LibraryManagementApplication.Reposiitory;

import com.Management.LibraryManagementApplication.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
