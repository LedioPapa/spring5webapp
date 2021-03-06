package ledio.guru.springframework.spring5webapp.bootstrap;

import ledio.guru.springframework.spring5webapp.model.Author;
import ledio.guru.springframework.spring5webapp.model.Book;
import ledio.guru.springframework.spring5webapp.model.Publisher;
import ledio.guru.springframework.spring5webapp.repository.AuthorRepository;
import ledio.guru.springframework.spring5webapp.repository.BookRepository;
import ledio.guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by ledio on 4/11/19
 */
@Component //now it's a bean
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

    private void initData() {

        //Publishers
        Publisher harperCollins = new Publisher("Harper Collins", "Address 1");
        Publisher worx = new Publisher("Worx", "Address 2");

        publisherRepository.save(harperCollins);
        publisherRepository.save(worx);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
