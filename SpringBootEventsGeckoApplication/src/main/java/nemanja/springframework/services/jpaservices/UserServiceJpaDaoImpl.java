package nemanja.springframework.services.jpaservices;

import nemanja.springframework.model.AppUser;
import nemanja.springframework.services.UserService;
import nemanja.springframework.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import java.util.List;


@Service
@Profile("jpadao")
public class UserServiceJpaDaoImpl extends AbstractJpaDaoService implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from User", AppUser.class).getResultList();
    }

    @Override
    public AppUser getById(Integer id) {
        EntityManager em = emf.createEntityManager();

        return em.find(AppUser.class, id);
    }

    @Override
    public AppUser saveOrUpdate(AppUser domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        if(domainObject.getEncrytedPassword() != null){
            domainObject.setEncrytedPassword(encryptionService.encryptString(domainObject.getEncrytedPassword()));
        }

        AppUser saveduser = em.merge(domainObject);
        em.getTransaction().commit();

        return saveduser;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(AppUser.class, id));
        em.getTransaction().commit();
    }

    @Override
    public AppUser findAppUserByUsername(String userName) {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from User where userName = :userName", AppUser.class).setParameter("userName", userName).getSingleResult();
    }
}
