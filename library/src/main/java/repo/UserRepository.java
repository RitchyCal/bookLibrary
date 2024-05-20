package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import api.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);

    List<User> findByName(String name);
}
