package com.xsis.blq.LibraryProject.controller;

import com.xsis.blq.LibraryProject.model.BookRequest;
import com.xsis.blq.LibraryProject.model.BookResponse;
import com.xsis.blq.LibraryProject.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public String addBook(@ModelAttribute("bookRequest") BookRequest bookRequest){
        bookService.addBook(bookRequest);
        return "redirect:/book";
    }

    @GetMapping("/book/new")
    public String addBookForm(Model model){
        BookRequest bookRequest = new BookRequest();
        model.addAttribute("bookRequest", bookRequest);
        return "add_book";
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable("id") long bookId){
        BookResponse bookResponse = bookService.getBookById(bookId);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }

    @GetMapping("/book")
    public String getAllBook(Model model){
        List<BookResponse> bookResponses = bookService.getAllBook();
        model.addAttribute("bookResponse",bookResponses);
        return "library";
    }

    @GetMapping("/book/edit/{id}")
    public String editBookForm(@PathVariable("id") Long bookId, Model model){
        BookResponse bookResponse = bookService.getBookById(bookId);
        model.addAttribute("bookResponse", bookResponse);
        return "edit_book";
    }

    @PostMapping("/book/{id}")
    public String updateBook(@PathVariable("id") Long bookId, @ModelAttribute("bookResponse") BookResponse bookResponse){
        bookService.updateBook(bookId, bookResponse);
        return "redirect:/book";
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long bookId,
                                               @RequestParam long quantity){
        bookService.reduceQuantity(bookId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public String removeBook(@PathVariable("id") long bookId){
        bookService.removeBook(bookId);
        return "redirect:/book";
    }
}
