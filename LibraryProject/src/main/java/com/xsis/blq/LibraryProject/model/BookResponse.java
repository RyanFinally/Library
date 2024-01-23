package com.xsis.blq.LibraryProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private long bookId;
    private String author;
    private String title;
    private long price;
    private String rackNo;
    private String edition;
    private String dateOfPurchase;
    private long quantity;
}
