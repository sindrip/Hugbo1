package is.hi.byrjun.repository;

import is.hi.byrjun.model.Review;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 */
public interface ReviewRepository {
    /*
        Nær í öll review fyrir ákveðinn kúrs
     */
    List<Review> getReviewsForCourse(String longNumber);
    /*
        Bætir við kúrs
     */
    void add(Review review);
}
