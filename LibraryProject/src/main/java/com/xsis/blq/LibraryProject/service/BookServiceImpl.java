package com.xsis.blq.LibraryProject.service;

import com.xsis.blq.LibraryProject.entity.Book;
import com.xsis.blq.LibraryProject.model.BookRequest;
import com.xsis.blq.LibraryProject.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public long addBook(BookRequest bookRequest) {
        log.info("Add book ");

        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .price(bookRequest.getPrice())
                .edition(bookRequest.getEdition())
                .rackNo(bookRequest.getRackNo())
                .dateOfPurchase(bookRequest.getDateOfPurchase())
                .quantity(bookRequest.getQuantity())
                .build();

        bookRepository.save(book);
        log.info("Book added ");
        return book.getBookId();
    }
}
