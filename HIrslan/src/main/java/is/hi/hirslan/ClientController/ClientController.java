package is.hi.hirslan.ClientController;

import is.hi.hirslan.services.CourseService;
import is.hi.hirslan.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


/**
 *
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Tekur við skipunum frá vefviðmóti til að birta lista af námskeiðum eða
 * eitt sértækt námskeið
 */

@Controller
public class ClientController implements ErrorController {

    @Autowired
    CourseService courseService;
    @Autowired
    ReviewService reviewService;

    private static final String PATH = "/error";

    /**
     * Birtir villusíðu
     *
     * @return vefsíðu með villu
     */
    @RequestMapping(value = PATH)
    public String error(HttpServletRequest request, HttpServletResponse response,
                        Model model, Principal principal) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
        // Here we just define response body.
        model.addAttribute("userRole", getRole(principal));
        model.addAttribute("errorStatus", response.getStatus());
        return "error";
    }

    /**
     * Sækja error path
     * @return error path
     */
    @Override
    public String getErrorPath() {
        return PATH;
    }

    private String getRole(Principal principal) {
        String userRole = "ANONYMOUS";
        if (principal != null) {
            userRole = "USER";
        }
        return userRole;
    }

    /**
     * Birtir lista af námskeiðum
     *
     * @param model módel fyrir samskipti við viðmót
     * @return vefsíðu með lista af námskeiðum
     */
    // GET /
    @RequestMapping("")
    public String namskeid(Model model, Principal principal) {
        model.addAttribute("userRole", getRole(principal));
        return "courses";
    }

    /**
     * Birtir námskeið
     *
     *
     * @param langtNumer id fengið úr URLi
     * @param model módel fyrir samskipti við viðmót
     * @return vefsíðu með lista af námskeiðum
     */
    // GET /namskeid/:id
    @RequestMapping(value="namskeid/{id}")
    public String namskeidId(@PathVariable("id") String langtNumer, Principal principal, Model model) {
        model.addAttribute("userRole", getRole(principal));
        return "course";
    }

    @RequestMapping(value="signup")
    public String signUp(Principal principal, Model model) {
        model.addAttribute("userRole", getRole(principal));
        return "signup";
    }

    @RequestMapping(value="login")
    public String signIn(Principal principal, Model model) {
        model.addAttribute("userRole", getRole(principal));
        return "login";
    }

    @RequestMapping(value="logout")
    public String logout(Model model) {
        model.addAttribute("userRole", "ANONYMOUS");
        return "logout";
    }

    /**
     * Dæmi til að sýna prófanir með kalli á service klasa
     * @param model
     * @return skilar heima.html ef þjónustan "er á lífi" annars listiKennara
     */
    @RequestMapping (value = "/lifir")
    public String lifir(Model model) {
        if(courseService.erALifi())
            return "login";
        else
            return "logout";
    }

}