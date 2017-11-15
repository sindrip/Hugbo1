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

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date Október 2017
 * @description Controller fyrir usera.
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    //Tilviksbreyta af taginu UserService. Sér um tengingu við repository
    @Autowired
    private UserRepository userRepository;
    //Tilviksbreyta af taginu UserRepository. Sér um tenginu við gagnagrunn
    @Autowired
    private UserRoleRepository userRoleRepository;
    //TIlviksbreyta af taginu UserRoleRepository. Sér um tengingu við gagnagrunn
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    //Tilviksbreyta af taginu BCryptPasswordEncoder. Sér um að dulkóða skilaboð.


    /**
     * @description Sækir alla notendur úr gagnagrunni
     *
     * @List<User> Listi af notendum
     **/
    @RequestMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Býr til nýjan notanda ef nafnið er ekki nú þegar til
     *
     * @return notandanafnið sem var skráð, annars villu status
     **/
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