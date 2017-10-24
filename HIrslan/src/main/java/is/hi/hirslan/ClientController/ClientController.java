package is.hi.hirslan.ClientController;

import is.hi.hirslan.services.CourseService;
import is.hi.hirslan.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Tekur við skipunum frá vefviðmóti til að birta lista af námskeiðum eða
 * eitt sértækt námskeið
 */

@Controller
public class ClientController {

    @Autowired
    CourseService courseService;
    @Autowired
    ReviewService reviewService;

    /**
     * Birtir lista af námskeiðum
     *
     * @param model módel fyrir samskipti við viðmót
     * @return vefsíðu með lista af námskeiðum
     */
    // GET /
    @RequestMapping("")
    public String namskeid(Model model) {
        String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        System.out.println(user);
//        model.addAttribute("isAuthenticated", !user.equals("anonymousUser") );
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
    public String namskeidId(@PathVariable("id") String langtNumer, Model model) {
        model.addAttribute("course", courseService.singleCourse(langtNumer));
        model.addAttribute("review", reviewService.getReviewsForCourse(langtNumer));
        return "course";
    }

}