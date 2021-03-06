package nemanja.springframework.domain;

import nemanja.springframework.domain.AbstractDomainClass;
import nemanja.springframework.model.AppUser;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role extends AbstractDomainClass {

    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
   
    private List<AppUser> users = new ArrayList<>();

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }

    public void addUser(AppUser user){
        if(!this.users.contains(user)){
            this.users.add(user);
        }

        if(!user.getRoles().contains(this)){
            user.getRoles().add(this);
        }
    }

    public void removeUser(AppUser user){
        this.users.remove(user);
        user.getRoles().remove(this);
    }

}
