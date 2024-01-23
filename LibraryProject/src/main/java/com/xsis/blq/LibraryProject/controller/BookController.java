package com.xsis.blq.LibraryProject.controller;

import com.xsis.blq.LibraryProject.model.BookRequest;
import com.xsis.blq.LibraryProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
