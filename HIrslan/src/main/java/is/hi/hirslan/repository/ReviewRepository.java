package is.hi.hirslan.repository;


import is.hi.hirslan.model.Course;
import is.hi.hirslan.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date Október 2017
 * @description Repository fyrir umsagnir. Sér um að sækja umsagnir úr gagnagrunni
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
    /*
        Nær í öll review fyrir ákveðinn kúrs
        @param áfanginn sem verið er að sækja umsagnir um. Er af taginu course
     */
    List<Review> findByCourse(Course course);
    /*
        Bætir við ummælum um kúrs
        @param umsögn af taginu review.
     */
    Review save (Review review);


}