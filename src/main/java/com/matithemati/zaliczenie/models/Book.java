package com.matithemati.zaliczenie.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
public class Book {
    private String id;
    private String title;
    private String author;
}
