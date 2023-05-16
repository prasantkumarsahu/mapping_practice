package com.prasant.mappingpractice.repositories;

import com.prasant.mappingpractice.models.Book;
import org.springframework.data.repository.ListCrudRepository;

public interface IBookRepository extends ListCrudRepository<Book, String> {
}
