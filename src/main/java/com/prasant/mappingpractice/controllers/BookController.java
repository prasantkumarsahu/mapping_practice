package com.prasant.mappingpractice.controllers;

import com.prasant.mappingpractice.models.Book;
import com.prasant.mappingpractice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping()
    public String addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping()
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("{bookId}")
    public String updateBook(@PathVariable String bookId, @RequestBody Book book){
        return bookService.updateBookById(bookId, book);
    }

    @DeleteMapping("{bookId}")
    public String deleteBook(@PathVariable String bookId){
        return bookService.deleteBookById(bookId);
    }
}
