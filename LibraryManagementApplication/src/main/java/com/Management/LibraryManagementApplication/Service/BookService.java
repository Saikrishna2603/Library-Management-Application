package com.Management.LibraryManagementApplication.Service;

import com.Management.LibraryManagementApplication.Entity.Book;
import com.Management.LibraryManagementApplication.Entity.User;
import com.Management.LibraryManagementApplication.Reposiitory.BookRepository;
import com.Management.LibraryManagementApplication.Reposiitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private UserRepository userRepo;

    public List<Book> findAll()
    {
        return bookRepo.findAll();
    }
    public Book findBookById(Long Id)
    {
        return bookRepo.findById(Id).orElseThrow(()->new RuntimeException("Book Not Found"));
    }
    public Book save(Book book)
    {
        return bookRepo.save(book);
    }
    public void delete(Long id)
    {
        bookRepo.deleteById(id);
    }
    public Book borrowBook(Long BookId,Long UserId)
    {
        Book book=findBookById(BookId);
        User user=userRepo.findById(UserId).orElse(null);
        if(book !=null && !book.isBorrowed() && user!=null){
            book.setBorrowed(true);
            book.setBorrowedBy(user);
            return save(book);
        }
        return null;
    }
    public Book returnBook(Long BookId)
    {
        Book book=findBookById(BookId);
        if(book !=null && book.isBorrowed())
        {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return  save(book);
        }
        return null;
    }

}
