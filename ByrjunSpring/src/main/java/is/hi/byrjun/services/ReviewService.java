package is.hi.byrjun.services;

import is.hi.byrjun.model.Review;

import java.util.List;

/**
 * Created by Ketill on 2.10.2017.
 */
public interface ReviewService {
    public List<Review> getReviewsForCourse(String longNumber);

    //public Review save(Review review);
}
