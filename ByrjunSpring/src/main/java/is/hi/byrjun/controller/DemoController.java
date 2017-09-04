package is.hi.byrjun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Byrjunarcontroller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun
 */

@Controller
@RequestMapping("/demo") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /demo fyrir allar skipanir
public class DemoController {


    // Þar sem klasinn hefur slóðina "/demo", er þessi slóð "/demo/page"
    @RequestMapping("/page")
    public String demoPage(){
        return "demo/demo"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/demo.jsp
        // skoðið application.properties til að sjá hvernig slóðin er sett
    }
    // Þegar farið er inn á /demo/notandi sér þetta fall um að birta sýn
    @RequestMapping("/notandi")
    public String notandi (Model model) {
        model.addAttribute( "nafn", "nafnidmitt");
        return "demo/synaNotandi";
    }
    // Þegar farið er inn á /demo/spyrjaNotanda sér þetta fall um að birta sýn
    @RequestMapping("/spyrjaNotanda")
    public String spyrjaNotandi () {
        return "demo/hvadaNotandi";
    }

    // Þegar það kemur Post Request inn á slóðina /demo/hver þá sér þetta um að birta sýn
    @RequestMapping(value="/hver", method=RequestMethod.POST)
    public String hver (@RequestParam(value="nafn", required=false) String nafn, ModelMap model) {
        model.addAttribute("nafn", nafn);
        return "demo/synaNotandi";
    }

}