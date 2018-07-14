package nemanja.springframework.services;

import nemanja.springframework.model.AppUser;

public interface UserService extends CRUDService<AppUser> {

    AppUser findAppUserByUsername(String userName);

}
