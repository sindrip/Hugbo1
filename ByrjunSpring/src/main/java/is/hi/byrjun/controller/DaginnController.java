package is.hi.byrjun.controller;

import is.hi.byrjun.model.Kennari;
import is.hi.byrjun.services.DaginnService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ebba Þóra Hvannberg
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Tekur við skipunum frá vefviðmóti til að skrá nýjan kennara og birta lista af
 * kennurum
 */
@Controller
@RequestMapping("/demo") // Notice here that the Request Mapping is set at the Class level
public class DaginnController {

    // Tenging yfir í þjónustu klasa fyrir góðan daginn forritið 
    @Autowired
    DaginnService daginnService;
   

    /**
     * Býður sama notandanum góðan daginn
     *
     * @param model
     * @return vefsíðu sem býður notanda góðan daginn
     */
    @RequestMapping("/notandi")
    public String notandi(Model model) {
        model.addAttribute("nafn", "Ebba Þóra");
        return "demo/synaNotandi";
    }

    /**
     * Spyr hvað notandinn heitir
     *
     * @return vefsíða með spurningu
     */
    @RequestMapping("/spyrjaNotanda")
    public String spyrjaNotandi() {
        return "demo/hvadaNotandi";
    }

    /**
     * Tekur við nafni frá notanda og birtir Góðan daginn nafn ef nafnið er á
     * réttu sniði annars birtir það villumeldingu
     *
     * @param nafn Nafn á notanda
     * @param model Módel með attributum
     * @return vefsíðu sem birtir góðan daginn nafn 
     */
    @RequestMapping(value = "/hver", method = RequestMethod.POST)
    public String hver(@RequestParam(value = "nafn", required = false) String nafn, ModelMap model) {

        if (daginnService.erNafnRett(nafn)) {
            Kennari k = new Kennari(nafn, "Tómasarhagi");
            model.addAttribute("kennari", k);
            daginnService.addKennari(k);
            return "demo/synaKennari";
        } else {
            return "demo/rangtNafn";
        }
    }

    /**
     * Birtir lista af kennurum
     *
     * @param model módel fyrir samskipti við viðmót
     * @return vefsíðu með lista af kennurum
     */
    @RequestMapping(value = "/listiKennara", method = RequestMethod.GET)
    public String listiKennara(Model model) {
        ArrayList<Kennari> listi;
        listi = (ArrayList<Kennari>) daginnService.allirKennarar();
        model.addAttribute("kennarar", listi);
        return "demo/allirKennarar";
    }

}
