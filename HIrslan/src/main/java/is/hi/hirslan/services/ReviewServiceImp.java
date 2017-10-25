package is.hi.hirslan.services;

import is.hi.hirslan.model.Course;
import is.hi.hirslan.model.Review;
import is.hi.hirslan.repository.CourseRepository;
import is.hi.hirslan.repository.ReviewRepository;
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
        return reviewRep.findByCourse(courseRep.findByLangtNumer(langtNumer));
    }

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