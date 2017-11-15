package is.hi.hirslan.RESTController;


import is.hi.hirslan.model.Course;
import is.hi.hirslan.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 *
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Endapunktar fyrir APAnn okkar, skilar JSON listum af námskeiðum
 */


@RestController
@RequestMapping("/api/namskeid") // Notice here that the Request Mapping is set at the Class level
public class CourseController {

    @Autowired
    CourseService courseService;
    // Tilviksbreyta af taginu courseservices. Sér um að tala við course repositoryið fyrir controllerinn


    /**
     * Birtir lista af námskeiðum
     *
     * @return listi JSON listi allra námskeiða
     */
    // GET api/namskeid/
    @RequestMapping("")
    public ArrayList<Course> namskeid() {
        ArrayList<Course> listi;
        listi = (ArrayList<Course>) courseService.allCourse();
        return listi;
    }

    /**
     * Birtir lista af námskeiðum
     *
     * @param leit leitarstrengur
     * @return listi JSON listi námskeið þar sem leitarstrengurinn
     *         er innihaldinn í einhverjum field í módelinu
     */
    // GET api/namskeid/leit
    @RequestMapping(value = "/leit")
    public ArrayList<Course> namskeidLeit(@RequestParam(value="leit", required = true) String leit) {
        ArrayList<Course> listi;
        listi = (ArrayList<Course>) courseService.searchCourse(leit);
        return listi;
    }

    /**
     * Skilar einu námskeiði sem samsvarar id
     *
     * @return listi JSON listi eins námskeiðs
     */
    //GET api/namskeid/:id
    @RequestMapping(value  = "/{id}")
    public Course getReviews(@PathVariable("id") String langtNumer) {
        return courseService.singleCourse(langtNumer);
    }

}