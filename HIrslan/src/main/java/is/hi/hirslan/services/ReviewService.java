package is.hi.hirslan.services;

import is.hi.hirslan.model.Review;

import java.util.List;

/**
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date 2. Oktober 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Þjónusta sem talar við Review Repository
 */
public interface ReviewService {
    public List<Review> getReviewsForCourse(String longNumber);

    public Review save(Review review);
}