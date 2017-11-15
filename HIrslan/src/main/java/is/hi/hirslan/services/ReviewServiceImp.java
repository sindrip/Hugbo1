package is.hi.hirslan.services;

import is.hi.hirslan.model.Course;
import is.hi.hirslan.model.Review;
import is.hi.hirslan.repository.CourseRepository;
import is.hi.hirslan.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarso:email spi2@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 * @description Service klasi fyrir umsagnir.
 */

@Service
public class ReviewServiceImp implements ReviewService {

    /**
     * Tilviksbreyta af taginu ReviewRepository. Sér um að tala við gagnagrunn
     **/
    @Autowired
    ReviewRepository reviewRep;
    /**
     * Tilviksbreyta af taginu CourseRepository. Sér um að tala við gagnagrunn.
     **/
    @Autowired
    CourseRepository courseRep;

    /**
     * @description Sækir allar umsagnir fyrir tiltekið námskeið
     * @param String langtNumer sem hefur samsvarandi áfangi.
     * @return List<review> Listi yfir allar umsagnir fyrir námskeið
     **/
    @Override
    public List<Review> getReviewsForCourse(String langtNumer) {
        return reviewRep.findByCourse(courseRep.findByLangtNumer(langtNumer));
    }

    /**
     * @description Setur umsögn inn í gagnagrunn
     * @param Review. Sú umsögn sem á að setja í gagnagrunn
     * @return Review. Sú umsögn sem var sett í gagnagrunn
     **/
    @Override
    public Review save(Review review) {
        // Get course the review is for
        Course course = courseRep.findByLangtNumer(review.getCourse().getLangtNumer());
        // Get list of reviews for current course
        List<Review> reviews = reviewRep.findByCourse(review.getCourse());
        // Calculate new average grade based on new review
        double oldGrade = course.getAverageRank();
        if(oldGrade < 0) oldGrade = 0;
        double newGrade =  (oldGrade * reviews.size() + review.getRating()) / (reviews.size() + 1);
        // Update the grade of the course
        course.setAverageRank(newGrade);
        courseRep.save(course);
        // Save the new review
        return reviewRep.save(review);
    }

}