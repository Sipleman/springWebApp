package com.ilias.springWebApp.bootstrap;

import com.ilias.springWebApp.model.Author;
import com.ilias.springWebApp.model.Book;
import com.ilias.springWebApp.repositories.AuthorRepository;
import com.ilias.springWebApp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author author1 = new Author("Kendrik", "LAMAR");
        Book book1 = new Book("Very nice book","1423", "ROMAN");
        author1.getBooks().add(book1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        Author author2 = new Author("Kendrik", "LAMAR");
        Book book2 = new Book("Very nice book", "1424", "ROMAN");
        author2.getBooks().add(book2);
        authorRepository.save(author2);
        bookRepository.save(book2);
    }
}
