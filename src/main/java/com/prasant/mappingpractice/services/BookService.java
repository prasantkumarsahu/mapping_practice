package com.prasant.mappingpractice.services;

import com.prasant.mappingpractice.models.Book;
import com.prasant.mappingpractice.repositories.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private StudentService studentService;

    public String saveBook(Book book) {
        boolean isPresent = studentService.isStudentExist(book.getStudent().getId());
        if (!isPresent){
            return "Student doesn't exist!";
        }

        bookRepository.save(book);
        return "Book added successfully!";
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public String updateBookById(String bookId, Book book) {
        boolean isBookPresent = bookRepository.existsById(bookId);
        if (!isBookPresent){
            return "Book is not exist!";
        }

        boolean isPresent = studentService.isStudentExist(book.getStudent().getId());
        if (!isPresent){
            return "Student doesn't exist!";
        }

        book.setId(bookId);
        bookRepository.save(book);
        return "Book updated successfully!";
    }

    public String deleteBookById(String bookId) {
        boolean isPresent = bookRepository.existsById(bookId);
        if (!isPresent){
            return "Book doesn't exist!";
        }

        bookRepository.deleteById(bookId);
        return "Book deleted successfully!";
    }
}
