package guru.springframework.springwebapp.repositories;

import guru.springframework.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface BookRepository extends CrudRepository<Book, Id> {
}
