package is.hi.byrjun.repository;

import is.hi.byrjun.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Safn af Review (Umsögnum)
 */

@Repository
public class ReviewRepositoryImp {
    private final List<Review> review;

    public ReviewRepositoryImp() {
        this.review = new ArrayList<Review>();
        this.review.add( new Review("5051IÐN101G20176",5,"Ketill", new Date(),"Þetta er mjög flott"));
        this.review.add( new Review("5051IÐN101G20176",3,"Sindri", new Date(),"Fínn áfangi"));
        this.review.add( new Review("5051IÐN101G20176",1,"Björn", new Date(), "Hjálp, ég er ekkert í þessum áfanga"));

    }

    public List<Review> getReviewsForCourse(String longNumber) {
        List<Review> reviews = new ArrayList<Review>();
        for (int i = 0; i < review.size(); i++) {
            System.out.println(review.get(i).getLangtNumer());
            System.out.println(review.get(i).getLangtNumer().equals(longNumber));
            if( review.get(i).getLangtNumer().equals(longNumber)) {
                reviews.add(review.get(i));
            }
        }
        return reviews;
    }

    public void save(Review review) {
        this.review.add(review);
    }

}

