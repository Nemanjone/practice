package nemanja.springframework.repositories;

import nemanja.springframework.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer>{
}
