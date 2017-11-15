package is.hi.hirslan.services;

import is.hi.hirslan.model.User;
import is.hi.hirslan.model.UserRole;
import is.hi.hirslan.repository.UserRepository;
import is.hi.hirslan.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date Október 2017
 */

@Service
public class UserServiceImp implements UserService {
    /*
        * @description Tilviksbreyta af taginu UserRepository. Repository fyrir notendur
     */
    @Autowired
    UserRepository userRepository;
    /*
        * @description Tilviksbreyta af taginu UserRoleRepository. Repository fyrir hlutverk notenda.
     */
    @Autowired
    UserRoleRepository userRoleRepository;
    /*
        * @description Tilviksbreyta af taginu BCryptPasswordEncoder. Sér um að dulkóða lykilorð.
     */
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
