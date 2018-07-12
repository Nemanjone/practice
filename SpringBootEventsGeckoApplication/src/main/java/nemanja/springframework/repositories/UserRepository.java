package nemanja.springframework.repositories;

import nemanja.springframework.domain.User;
import org.springframework.data.repository.CrudRepository;
import java.lang.String;

public interface UserRepository extends CrudRepository<User, Integer>{
        User findByUsername(String username);
}