package com.xsis.blq.LibraryProject.controller;

import com.xsis.blq.LibraryProject.model.BookRequest;
import com.xsis.blq.LibraryProject.model.BookResponse;
import com.xsis.blq.LibraryProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Long> addBook(@RequestBody BookRequest bookRequest){
        long bookId = bookService.addBook(bookRequest);
        return new ResponseEntity<>(bookId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable("id") long bookId){
        BookResponse bookResponse = bookService.getBookById(bookId);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }
}
