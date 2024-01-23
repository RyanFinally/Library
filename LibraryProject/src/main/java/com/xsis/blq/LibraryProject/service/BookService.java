package com.xsis.blq.LibraryProject.service;

import com.xsis.blq.LibraryProject.model.BookRequest;
import com.xsis.blq.LibraryProject.model.BookResponse;

public interface BookService {
    long addBook(BookRequest bookRequest);

    BookResponse getBookById(long bookId);
}
