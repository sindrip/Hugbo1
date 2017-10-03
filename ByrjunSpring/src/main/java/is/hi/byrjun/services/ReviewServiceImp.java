package is.hi.byrjun.services;

import is.hi.byrjun.model.Course;
import is.hi.byrjun.model.Review;
import is.hi.byrjun.repository.CourseRepository;
import is.hi.byrjun.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 */

@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    ReviewRepository reviewRep;
    @Autowired
    CourseRepository courseRep;

    @Override
    public List<Review> getReviewsForCourse(String langtNumer) {
        return reviewRep.findByLangtNumer(langtNumer);
    }

    @Override
    public Review save(Review review) {
        // Get course the review is for
        Course course = courseRep.findByLangtNumer(review.getLangtNumer());
        // Get list of reviews for current course
        List<Review> reviews = reviewRep.findByLangtNumer(review.getLangtNumer());
        // Calculate new average grade based on new review
        double newGrade =  (course.getAverageRank() * reviews.size() + review.getRating()) / (reviews.size() + 1);
        // Update the grade of the course
        course.setAverageRank(newGrade);
        courseRep.save(course);
        // Save the new review
        return reviewRep.save(review);
    }

}
