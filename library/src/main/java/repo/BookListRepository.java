package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.BookList;
import java.util.List;

public interface BookListRepository extends JpaRepository<BookList, Integer> {
         List<BookList> findAllByUserId(int userId);
}
