package com.xsis.blq.LibraryProject.service;

import com.xsis.blq.LibraryProject.model.BookRequest;
import com.xsis.blq.LibraryProject.model.BookResponse;

import java.util.List;

public interface BookService {
    long addBook(BookRequest bookRequest);

    BookResponse getBookById(long bookId);

    void reduceQuantity(long bookId, long quantity);

    void removeBook(long bookId);

    List<BookResponse> getAllBook();

    void updateBook(Long bookId, BookResponse bookResponse);
}
