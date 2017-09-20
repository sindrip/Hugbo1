package is.hi.byrjun.controller.API;

import is.hi.byrjun.model.Kennari;
import is.hi.byrjun.model.Namskeid;
import is.hi.byrjun.services.DaginnService;

import java.lang.reflect.Array;
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
@RequestMapping("/api/namskeid") // Notice here that the Request Mapping is set at the Class level
public class NamskeidAPIController {

    @Autowired
    NamskeidService namskeidService;


    // GET /namskeid/
    @RequestMapping("")
    public ArrayList<Namskeid> namskeid() {
        ArrayList<Namskeid> listi;
        listi = (ArrayList<Namskeid>) namskeidService.allNamskeid();
        return listi;
//        model.addAttribute("namskeid", listi);
//        model.addAttribute("pageTitle", "Öll námskeið");
//        return "namskeid/namskeid";
    }

    // GET /namskeid/leit
    @RequestMapping(value = "/leit")
    public ArrayList<Namskeid> namskeidLeit(@RequestParam(value="leit", required = true) String leit) {
        ArrayList<Namskeid> listi;
        listi = (ArrayList<Namskeid>) namskeidService.searchNamskeid(leit);
        return listi;
//        model.addAttribute("namskeid", listi);
//        model.addAttribute("pageTitle", "Leitarniðurstöður");
//        return "namskeid/namskeid";
    }

}
