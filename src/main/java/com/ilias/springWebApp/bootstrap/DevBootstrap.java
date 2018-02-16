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
        Publisher p1 = new Publisher("Dutton");
        Publisher p2 = new Publisher("Maxwell perkins");
        Publisher p3 = new Publisher("EGF");

        publisherRepository.save(p1);
        publisherRepository.save(p2);
        publisherRepository.save(p3);

        Author author1 = new Author("Stephen", "King");
        Book book1 = new Book("Shine","1423", p1);
        author1.getBooks().add(book1);
        bookRepository.save(book1);
        authorRepository.save(author1);

        Author author2 = new Author("Ernest", "Hemingway");
        Book book2 = new Book("For whom the bell calls", "1424", p2);
        author2.getBooks().add(book2);
        authorRepository.save(author2);
        bookRepository.save(book2);

        Author author3 = new Author("Fyodor", "Dostoevsky");
        Book book3 = new Book("Idiot", "4123", p3);
        author3.getBooks().add(book3);
        authorRepository.save(author3);
        bookRepository.save(book3);

    }
}
