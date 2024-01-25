package com.xsis.blq.LibraryProject.service;

import com.xsis.blq.LibraryProject.entity.Book;
import com.xsis.blq.LibraryProject.exception.BookException;
import com.xsis.blq.LibraryProject.model.BookRequest;
import com.xsis.blq.LibraryProject.model.BookResponse;
import com.xsis.blq.LibraryProject.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.*;

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
                .orElseThrow(()-> new BookException("Book with given id not found", "BOOK_NOT_FOUND"));
        BookResponse bookResponse = new BookResponse();
        copyProperties(book,bookResponse);

        return bookResponse;
    }

    @Override
    public void reduceQuantity(long bookId, long quantity) {
        log.info("Reduce {} book from {}", quantity,bookId);
        Book book = bookRepository
                .findById(bookId)
                .orElseThrow(()-> new BookException("Book with given id not found", "BOOK_NOT_FOUND"));

        if(book.getQuantity()<quantity){
            throw new RuntimeException("Invalid amount");
        }

        book.setQuantity(book.getQuantity()-quantity);
        bookRepository.save(book);
        log.info("Book quantity is updated");
    }

    @Override
    public void removeBook(long bookId) {
        log.info("Remove book with id: {}", bookId);
        Book book = bookRepository
                .findById(bookId)
                .orElseThrow(()-> new BookException("Book with given id not found", "BOOK_NOT_FOUND"));
        bookRepository.delete(book);
        log.info("Book Removed");
    }

    @Override
    public List<BookResponse> getAllBook() {
        log.info("List of books");
        List<Book> allBook = bookRepository.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        for (Book book : allBook) {
            BookResponse bookResponse = new BookResponse();
            BeanUtils.copyProperties(book, bookResponse);
            bookResponses.add(bookResponse);
        }
        return bookResponses;
    }

    @Override
    public void updateBook(Long bookId, BookResponse bookResponse) {
        log.info("Update book with id : {}", bookId);
        Book book = Book.builder()
                .bookId(bookId)
                .title(bookResponse.getTitle())
                .author(bookResponse.getAuthor())
                .price(bookResponse.getPrice())
                .edition(bookResponse.getEdition())
                .rackNo(bookResponse.getRackNo())
                .dateOfPurchase(bookResponse.getDateOfPurchase())
                .quantity(bookResponse.getQuantity())
                .build();

        bookRepository.save(book);
        log.info("Book updated");
    }
}
