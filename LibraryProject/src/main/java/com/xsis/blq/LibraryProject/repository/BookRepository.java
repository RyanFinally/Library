package com.xsis.blq.LibraryProject.repository;

import com.xsis.blq.LibraryProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
