package is.hi.hirslan.repository;


import is.hi.hirslan.model.Course;
import is.hi.hirslan.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
    /*
        Nær í öll review fyrir ákveðinn kúrs
     */
    List<Review> findByCourse(Course course);
    /*
        Bætir við ummælum um kúrs
     */
    Review save (Review review);


}