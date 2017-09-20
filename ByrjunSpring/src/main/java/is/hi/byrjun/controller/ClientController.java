package is.hi.byrjun.controller;

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


@Controller
@RequestMapping("") // Notice here that the Request Mapping is set at the Class level
public class ClientController {

    // GET /namskeid/
    @RequestMapping("namskeid")
    public String namskeid(Model model) {
        model.addAttribute("pageTitle", "Öll námskeið");
        return "view/namskeid";
    }

//    // GET /namskeid/leit
//    @RequestMapping(value = "/leit")
//    public ArrayList<Namskeid> namskeidLeit(@RequestParam(value="leit", required = true) String leit) {
//        ArrayList<Namskeid> listi;
//        listi = (ArrayList<Namskeid>) namskeidService.searchNamskeid(leit);
//        return listi;
//        model.addAttribute("namskeid", listi);
//        model.addAttribute("pageTitle", "Leitarniðurstöður");
//        return "namskeid/namskeid";
//    }

}
