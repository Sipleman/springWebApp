package com.ilias.springWebApp.repositories;

import com.ilias.springWebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
