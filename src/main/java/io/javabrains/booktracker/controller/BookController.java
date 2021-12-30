package io.javabrains.booktracker.controller;

import io.javabrains.booktracker.model.Book;
import io.javabrains.booktracker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/books/{bookId}")
    public String getBook(@PathVariable(value = "bookId") String bookId, Model model) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            model.addAttribute("book", book);
            return "book";
        }
        return "book-not-found";
    }

}
