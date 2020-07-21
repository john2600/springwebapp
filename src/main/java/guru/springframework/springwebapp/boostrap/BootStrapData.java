package guru.springframework.springwebapp.boostrap;

import guru.springframework.springwebapp.model.Author;
import guru.springframework.springwebapp.model.Book;
import guru.springframework.springwebapp.model.Publisher;
import guru.springframework.springwebapp.repositories.AuthorRepository;
import guru.springframework.springwebapp.repositories.BookRepository;
import guru.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository=authorRepository;
        this.bookRepository= bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Author gabrielGarcia = new Author("Gabriel","Garcia Marquez");
        Book book1 = new Book("Cien Años de Soledad","9788420471839");
        book1.getAuthors().add(gabrielGarcia);
        gabrielGarcia.getBooks().add(book1);

        Book book2 = new Book("Amor en los tiempos del colera","9788439728351");
        book2.getAuthors().add(gabrielGarcia);
        gabrielGarcia.getBooks().add(book2);

        authorRepository.save(gabrielGarcia);
        bookRepository.save(book1);
        bookRepository.save(book2);

        Author carSagan = new Author("Carl","Sagan");
        Book bookSagan = new Book("El mundo y sus demonios","9788434228351");
        carSagan.getBooks().add(bookSagan);
        bookSagan.getAuthors().add(carSagan);

        authorRepository.save(carSagan);
        bookRepository.save(bookSagan);

        System.out.println("Started BootStrap");
        System.out.println("count registers in author repo: "+authorRepository.count());
        System.out.println("count registers in book repo: "+bookRepository.count());

        Publisher publisher = new Publisher("Street 14/16","New York","NY","A2D101");

        publisherRepository.save(publisher);
        System.out.println("publisher "+publisherRepository.count());
        List<Publisher> publisherObject = (List<Publisher>) publisherRepository.findAll();

        publisherObject.forEach(x->System.out.println(x.toString()));



    }
}
