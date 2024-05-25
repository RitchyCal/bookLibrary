package repo;


import org.springframework.data.jpa.repository.JpaRepository;
import api.model.Book;
import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Integer> {
    Book findByBookName(String bookName);
    List<Book> findAllByGenre (String genre);
}
