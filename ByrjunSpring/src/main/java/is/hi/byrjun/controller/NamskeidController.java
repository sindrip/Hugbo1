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
import org.springframework.web.bind.annotation.RestController;

//
//


@RestController
@RequestMapping("/namskeid") // Notice here that the Request Mapping is set at the Class level
public class NamskeidController {

    @Autowired
    NamskeidService namskeidService;


    // GET /namskeid/
    @RequestMapping("")
    public ArrayList<Namskeid> namskeid(Model model) {
        ArrayList<Namskeid> listi;
        listi = (ArrayList<Namskeid>) namskeidService.allNamskeid();
        return listi;
//        model.addAttribute("namskeid", listi);
//        model.addAttribute("pageTitle", "Öll námskeið");
//        return "namskeid/namskeid";
    }
//
//    // GET /namskeid/leit
//    @RequestMapping(value = "/leit", produces = "application/json")
//    public String namskeid(@RequestParam(value="leit", required = true) String leit, Model model) {
//        ArrayList<Namskeid> listi;
//        listi = (ArrayList<Namskeid>) namskeidService.searchNamskeid(leit);
//        model.addAttribute("namskeid", listi);
//        model.addAttribute("pageTitle", "Leitarniðurstöður");
//        return "namskeid/namskeid";
//    }

}
