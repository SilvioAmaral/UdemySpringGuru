package com.newspark.udemy.bootstrap;

import com.newspark.udemy.domain.Author;
import com.newspark.udemy.domain.Book;
import com.newspark.udemy.repository.AuthorRepository;
import com.newspark.udemy.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Author eric = new Author(1L, "Eric", "Evans");
//        Author rod = new Author(2L, "Rod", "Johnson");
//
//        Book ddd = new Book(1L, "Domain Driven Design", "123123");
//        Book ejb = new Book(2L, "Enterprise Java Beans", "321321");
//
//        Author ericSaved = authorRepository.save(eric);
//        Author rodSaved = authorRepository.save(rod);
//
//        Book dddSaved = bookRepository.save(ddd);
//        Book ejbSaved = bookRepository.save(ejb);
//
//        ericSaved.getBooks().add(dddSaved);
//        rodSaved.getBooks().add(ejbSaved);
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());


    }
}