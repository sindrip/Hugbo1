package is.hi.byrjun.controller;

import is.hi.byrjun.model.Kennari;
import is.hi.byrjun.model.Namskeid;
import is.hi.byrjun.services.DaginnService;
import java.util.ArrayList;

import is.hi.byrjun.services.NamskeidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//
//


@Controller
@RequestMapping("/namskeid") // Notice here that the Request Mapping is set at the Class level
public class NamskeidController {

    @Autowired
    NamskeidService namskeidService;


    // GET /namskeid
    @RequestMapping("")
    public String namskeid(Model model) {
        ArrayList<Namskeid> listi;
        listi = (ArrayList<Namskeid>) namskeidService.namskeid();
        model.addAttribute("namskeid", listi);
        return "namskeid/namskeidsListi";
    }

}
