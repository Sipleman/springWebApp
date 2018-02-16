package com.ilias.springWebApp.repositories;

import com.ilias.springWebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
