package com.matithemati.zaliczenie.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class BookDto {
    @NonNull
    private String title;

    @NonNull
    private String author;
}
