package is.hi.byrjun.controller;

import is.hi.byrjun.services.CourseService;
import is.hi.byrjun.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("") // Notice here that the Request Mapping is set at the Class level
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
    // GET /namskeid/
    @RequestMapping("namskeid")
    public String namskeid(Model model) {
        model.addAttribute("pageTitle", "Öll námskeið");
        return "view/courses";
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
        return "view/course";
    }

}
