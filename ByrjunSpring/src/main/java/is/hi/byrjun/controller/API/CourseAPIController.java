package is.hi.byrjun.controller.API;

import is.hi.byrjun.model.Course;

import java.util.ArrayList;

import is.hi.byrjun.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//
//


@RestController
@RequestMapping("/api/namskeid") // Notice here that the Request Mapping is set at the Class level
public class CourseAPIController {

    @Autowired
    CourseService courseService;


    // GET /namskeid/
    @RequestMapping("")
    public ArrayList<Course> namskeid() {
        ArrayList<Course> listi;
        listi = (ArrayList<Course>) courseService.allCourse();
        return listi;
//        model.addAttribute("namskeid", listi);
//        model.addAttribute("pageTitle", "Öll námskeið");
//        return "namskeid/namskeid";
    }

    // GET /namskeid/leit
    @RequestMapping(value = "/leit")
    public ArrayList<Course> namskeidLeit(@RequestParam(value="leit", required = true) String leit) {
        ArrayList<Course> listi;
        listi = (ArrayList<Course>) courseService.searchCourse(leit);
        return listi;
//        model.addAttribute("namskeid", listi);
//        model.addAttribute("pageTitle", "Leitarniðurstöður");
//        return "namskeid/namskeid";
    }

}
