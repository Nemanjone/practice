package nemanja.springframework.bootstrap;

import nemanja.springframework.domain.Event;
import nemanja.springframework.domain.Role;
import nemanja.springframework.model.AppUser;
import nemanja.springframework.repositories.EventRepository;
import nemanja.springframework.services.RoleService;
import nemanja.springframework.services.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private EventRepository eventRepository;
    private UserService userService;
    private RoleService roleService;

    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadEvents();
        loadUsers();
        loadRoles();
        assignUsersToUserRole();
        assignUsersToAdminRole();
    }

    private void loadEvents() {
    	
        Event conference = new Event();
        
        conference.setEventName("Java Brain");
        conference.setCreatedBy("Milan Gutovic");
        conference.setStartingDate("23.5.2018.");
        conference.setStartingTime("12.00.");
        conference.setPlace("Crown Plaza");
        conference.setId(457);
        eventRepository.save(conference);

        log.info("Saved Conference - id: " + conference.getId());

        Event meeting = new Event();
        
        meeting.setEventName("GetTogether");
        meeting.setCreatedBy("Jeremy Brown");
        meeting.setStartingDate("25.8.2019.");
        meeting.setStartingTime("15.00.");
        meeting.setPlace("Hilton");
        meeting.setId(458);
        eventRepository.save(meeting);
        
        log.info("Saved Meeting - id: " + meeting.getId());
    }

    private void loadUsers() {
        AppUser user1 = new AppUser();
        user1.setUserId(2L);
        user1.setUserName("user");
        user1.setEncrytedPassword("user");
        user1.setFirstName("Nemanja");
        user1.setLastName("Balaban");
        user1.setEnabled(true);
        user1.setEmail("user@gmail.com");
        user1.setEncrytedPassword("123");
        userService.saveOrUpdate(user1);

       /* AppUser user2 = new AppUser();
        user2.setUserName("admin");
        user2.setEncrytedPassword("admin");
        userService.saveOrUpdate(user2);
*/
    }

    private void loadRoles() {
    	
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        log.info("Saved role" + role.getRole());
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        log.info("Saved role" + adminRole.getRole());
    }
    private void assignUsersToUserRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<AppUser> users = (List<AppUser>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
                users.forEach(user -> {
                    if (user.getUserName().equals("user")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
    private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<AppUser> users = (List<AppUser>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUserName().equals("admin")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
}
