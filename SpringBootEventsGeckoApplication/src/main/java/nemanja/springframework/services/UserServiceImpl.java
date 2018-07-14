package nemanja.springframework.services;

import nemanja.springframework.model.AppUser;
import nemanja.springframework.repositories.UserRepository;
import nemanja.springframework.services.UserService;
import nemanja.springframework.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }


    @Override
    public List<?> listAll() {
        List<AppUser> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); 
        return users;
    }

    @Override
    public AppUser getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public AppUser saveOrUpdate(AppUser domainObject) {
        if(domainObject.getEncrytedPassword() != null){
            domainObject.setEncrytedPassword(encryptionService.encryptString(domainObject.getEncrytedPassword()));
        }
        return userRepository.save(domainObject);
    }
    @Override
    @Transactional
       public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public AppUser findAppUserByUsername(String userName) {
        return userRepository.findAppUserByUsername(userName);
    }
}
