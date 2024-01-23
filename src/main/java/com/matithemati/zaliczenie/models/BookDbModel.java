package com.matithemati.zaliczenie.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@SuperBuilder
@Data
@NoArgsConstructor
public class BookDbModel {
    @Id
    private String id;
    private String title;
    private String author;
}
