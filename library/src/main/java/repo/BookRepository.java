package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import api.model.Book;

public interface BookRepository  extends JpaRepository<Book, Integer> {

}
