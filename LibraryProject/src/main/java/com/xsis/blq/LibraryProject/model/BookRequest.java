package com.xsis.blq.LibraryProject.model;

import lombok.Data;

@Data
public class BookRequest {
    private long bookId;
    private String author;
    private String title;
    private long price;
    private String rackNo;
    private String edition;
    private String dateOfPurchase;
    private long quantity;
}
