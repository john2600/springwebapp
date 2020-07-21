package guru.springframework.springwebapp.repositories;

import guru.springframework.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface PublisherRepository extends CrudRepository<Publisher, Id> {

}
