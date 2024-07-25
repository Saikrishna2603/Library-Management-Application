package com.Management.LibraryManagementApplication.Controller;

import com.Management.LibraryManagementApplication.Entity.Book;
import com.Management.LibraryManagementApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController
{
    @Autowired
    public BookService bookService;

    @GetMapping
    public List<Book> getAllBooks()
    {
        return bookService.findAll();
    }
    @PostMapping("/addBook")
    public  Book addBook(@RequestBody Book book)
    {
        return bookService.save(book);
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id)
    {
        return bookService.findBookById(id);
    }
    @DeleteMapping("/{id}")
    public void DeleteBook(@PathVariable Long id)
    {
        bookService.delete(id);
    }
    @PutMapping("/updateBook/{id}")
    public Book Updatebook(@PathVariable Long bookId,@RequestBody Book book)
    {
        //Additional Logic to update book
         return bookService.save(book);
    }
    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowbook(@PathVariable Long bookId, @PathVariable Long userId)
    {

         Book borrowedbook=bookService.borrowBook(bookId,userId);
         if(borrowedbook !=null)
         {
            return ResponseEntity.ok(borrowedbook);
         }
         else {
            return ResponseEntity.badRequest().build();
         }
    }
    @PostMapping("/returnBook/{bookId}")
    public ResponseEntity<Book> returnbook(@PathVariable Long bookId)
    {
        Book returnedbook=bookService.returnBook(bookId);
                if(returnedbook !=null)
                {
                    return  ResponseEntity.ok(returnedbook);
                }
                else
                {
                    return  ResponseEntity.badRequest().build();
                }
    }



}
