package is.hi.hirslan.services;

import is.hi.hirslan.model.User;
import is.hi.hirslan.model.UserRole;
import is.hi.hirslan.repository.UserRepository;
import is.hi.hirslan.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User signup (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User exists = userRepository.findByUsername(user.getUsername());

        if (exists != null) {
            return null;
        }

        userRepository.save(user);

        UserRole basicRole = new UserRole();
        basicRole.setUser(user);
        basicRole.setRole("USER");
        userRoleRepository.save(basicRole);

        return user;
    }
}
