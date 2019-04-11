package ledio.guru.springframework.spring5webapp.repository;

import ledio.guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ledio on 4/11/19
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
