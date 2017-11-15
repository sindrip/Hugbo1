package is.hi.hirslan.security;

import is.hi.hirslan.model.User;
import is.hi.hirslan.model.UserRole;
import is.hi.hirslan.repository.UserRepository;
import is.hi.hirslan.repository.UserRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date October 2017
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }


        List<GrantedAuthority> grantedAuths = userRoleRepository.findByUser(user)
                .stream()
                .map(ur -> new SimpleGrantedAuthority(ur.getRole()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                grantedAuths
        );
    }
}