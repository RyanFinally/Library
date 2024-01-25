package com.xsis.blq.LibraryProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "rack_number", nullable = false)
    private String rackNo;

    @Column(name = "edition", nullable = false)
    private String edition;

    @Column(name = "date_of_purchase", nullable = false)
    private LocalDate dateOfPurchase;

    @Column(name = "quantity", nullable = false)
    private long quantity;
}
