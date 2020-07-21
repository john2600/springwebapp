package guru.springframework.springwebapp.repositories;

import guru.springframework.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface AuthorRepository extends CrudRepository<Author, Id> {
}
