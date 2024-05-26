package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.BookList;

public interface BookListRepository extends JpaRepository<BookList, Integer> {

}
