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
    List<Review> findByLangtNumer(String langtNumer);
    /*
        Bætir við ummælum um kúrs
     */
    //Review save(Review review);
}
