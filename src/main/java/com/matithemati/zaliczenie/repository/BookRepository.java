package com.matithemati.zaliczenie.repository;

import com.matithemati.zaliczenie.models.BookDbModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookDbModel, String> {
}
