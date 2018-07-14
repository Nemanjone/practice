package nemanja.springframework.repositories;

import nemanja.springframework.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import java.lang.String;


public interface UserRepository extends CrudRepository<AppUser, Integer>{
	AppUser findAppUserByUsername(String userName);
}