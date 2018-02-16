package com.ilias.springWebApp.bootstrap;

import com.ilias.springWebApp.model.Author;
import com.ilias.springWebApp.model.Book;
import com.ilias.springWebApp.model.Publisher;
import com.ilias.springWebApp.repositories.AuthorRepository;
import com.ilias.springWebApp.repositories.BookRepository;
import com.ilias.springWebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author author1 = new Author("Kendrik", "LAMAR");
        Publisher p1 = new Publisher("Romans");
        publisherRepository.save(p1);

        Book book1 = new Book("Very nice book","1423", p1);
        author1.getBooks().add(book1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        Author author2 = new Author("Kendrik", "LAMAR");
        Publisher p2 = new Publisher("Another");
        Book book2 = new Book("Very nice book", "1424", p2);
        author2.getBooks().add(book2);
        authorRepository.save(author2);
        publisherRepository.save(p2);
        bookRepository.save(book2);
    }
}
