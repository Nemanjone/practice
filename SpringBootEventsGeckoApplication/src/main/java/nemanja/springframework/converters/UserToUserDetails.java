package nemanja.springframework.converters;


import nemanja.springframework.model.AppUser;
import nemanja.springframework.services.security.UserDetailsImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserToUserDetails implements Converter<AppUser, UserDetails> {
    @Override
    public UserDetails convert(AppUser user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();

        if (user != null) {
            userDetails.setUserName(user.getUserName());
            userDetails.setEncrytedPassword(user.getEncrytedPassword());
            userDetails.setEnabled(user.isEnabled());
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            });
            userDetails.setAuthorities(authorities);
        }

        return userDetails;
    }
}
