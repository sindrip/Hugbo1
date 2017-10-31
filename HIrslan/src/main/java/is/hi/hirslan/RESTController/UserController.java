package is.hi.hirslan.RESTController;

import is.hi.hirslan.model.User;
import is.hi.hirslan.repository.UserRepository;
import is.hi.hirslan.repository.UserRoleRepository;
import is.hi.hirslan.services.UserService;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody User user,
                                 HttpServletResponse response) {
        User savedUser;
        try {
            savedUser = userService.signup(user);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Lykilorð eða netfang á röngu sniði";
        }

        if (savedUser == null) {
            response.setStatus( HttpServletResponse.SC_CONFLICT);
            return "Notandanafn er nú þegar til";
        }

        return JSONFunctions.quote(savedUser.getUsername());
    }
}