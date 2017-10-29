package is.hi.hirslan.RESTController;

import is.hi.hirslan.model.Review;
import is.hi.hirslan.services.CourseService;
import is.hi.hirslan.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Endapunktar fyrir APAnn okkar, skilar JSON listum af námskeiðum
 */


@RestController
@RequestMapping("/api/review") // Notice here that the Request Mapping is set at the Class level
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    @Autowired
    CourseService courseService;


    /**
     * Bi
     *
     * @return
     */
    // POST api/review/namskeid/:id
    @RequestMapping(value = "namskeid/{id}", method = RequestMethod.POST )
    public Review saveReview(@PathVariable("id") String langtNumer,
                             @RequestBody Review review, Principal principal) {
        System.out.println(review);
        Review savedReview;
        review.setCourse(courseService.singleCourse(langtNumer));
        review.setAuthor(principal.getName());
        savedReview = reviewService.save(review);
        return savedReview;
    }

    //GET api/review/namskeid/:id
    @RequestMapping(value  = "namskeid/{id}")
    public List<Review> getReviews(@PathVariable("id") String langtNumer) {
        return reviewService.getReviewsForCourse(langtNumer);
    }


}