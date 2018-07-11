package nemanja.springframework.services;

import nemanja.springframework.domain.User;

public interface UserService extends CRUDService<User> {

    User findByUsername(String username);

}
