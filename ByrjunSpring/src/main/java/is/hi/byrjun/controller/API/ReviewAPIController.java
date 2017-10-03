package is.hi.byrjun.controller.API;

import is.hi.byrjun.model.Course;

import java.util.ArrayList;

import is.hi.byrjun.model.Review;
import is.hi.byrjun.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Endapunktar fyrir APAnn okkar, skilar JSON listum af námskeiðum
 */


@RestController
@RequestMapping("/api/review") // Notice here that the Request Mapping is set at the Class level
public class ReviewAPIController {

    @Autowired
    ReviewService reviewService;


    /**
     * Birtir lista af námskeiðum
     *
     * @return listi JSON listi allra námskeiða
     */
    // POST api/review/course/:id
    @RequestMapping(value = "course/{id}", method = RequestMethod.POST )
    public Review saveReview(@PathVariable("id") String langtNumer, @RequestBody Review review) {
        System.out.println(review);
        Review savedReview;
        review.setLangtNumer(langtNumer);
        savedReview = reviewService.save(review);
        return savedReview;
    }

}
