package is.hi.byrjun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//
//


@Controller
@RequestMapping("") // Notice here that the Request Mapping is set at the Class level
public class ClientController {

    // GET /namskeid/
    @RequestMapping("namskeid")
    public String namskeid(Model model) {
        model.addAttribute("pageTitle", "Öll námskeið");
        return "view/course";
    }

//    // GET /namskeid/leit
//    @RequestMapping(value = "/leit")
//    public ArrayList<Course> namskeidLeit(@RequestParam(value="leit", required = true) String leit) {
//        ArrayList<Course> listi;
//        listi = (ArrayList<Course>) namskeidService.searchCourse(leit);
//        return listi;
//        model.addAttribute("namskeid", listi);
//        model.addAttribute("pageTitle", "Leitarniðurstöður");
//        return "namskeid/namskeid";
//    }

}
