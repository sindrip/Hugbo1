package is.hi.byrjun.services;

import is.hi.byrjun.model.Review;
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

    @Override
    public List<Review> getReviewsForCourse(String langtNumer) {
        return reviewRep.findByLangtNumer(langtNumer);
    }

}
