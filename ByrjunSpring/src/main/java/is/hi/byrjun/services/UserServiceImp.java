package is.hi.byrjun.services;


import is.hi.byrjun.model.User;
import is.hi.byrjun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp  implements UserService{
    @Autowired
    UserRepository userRep;

    @Override
    public List<User> allUser() {
        return userRep.findAll();
    }

    @Override
    public User singleUser(String email){
        return userRep.findByEmail(email);
    }

    public User save(User user) {
        return userRep.save(user);
    }

}