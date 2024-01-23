package com.xsis.blq.LibraryProject.service;

import com.xsis.blq.LibraryProject.entity.Book;
import com.xsis.blq.LibraryProject.model.BookRequest;
import com.xsis.blq.LibraryProject.model.BookResponse;
import com.xsis.blq.LibraryProject.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @Override
    public BookResponse getBookById(long bookId) {
        log.info("Get the book for book id: {}",bookId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()-> new RuntimeException("Book not found"));
        BookResponse bookResponse = new BookResponse();
        BeanUtils.copyProperties(book,bookResponse);

        return bookResponse;
    }
}
