package nemanja.springframework.services.mapservices;

import nemanja.springframework.domain.DomainObject;
import nemanja.springframework.model.AppUser;
import nemanja.springframework.services.UserService;
import nemanja.springframework.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


@Service
@Profile("map")
public class UserServiceMapImpl extends AbstractMapService implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public AppUser getById(Integer id) {
        return (AppUser) super.getById(id);
    }

    
    @Override
    public AppUser saveOrUpdate(AppUser domainObject) {

        if(domainObject.getEncrytedPassword() != null){
            domainObject.setEncrytedPassword(encryptionService.encryptString(domainObject.getEncrytedPassword()));
        }

        return (AppUser) super.saveOrUpdate((DomainObject) domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public AppUser findAppUserByUsername(String userName) {

        Optional returnUser =  domainMap.values().stream().filter(new Predicate<DomainObject>() {
            @Override
            public boolean test(DomainObject domainObject) {
                AppUser user = (AppUser) domainObject;
                return user.getUserName().equalsIgnoreCase(userName);
            }
        }).findFirst();

        return (AppUser) returnUser.get();
    }
}
