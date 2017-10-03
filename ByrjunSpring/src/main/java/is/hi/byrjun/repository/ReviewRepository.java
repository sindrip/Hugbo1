package is.hi.byrjun.repository;

import is.hi.byrjun.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
    /*
        Nær í öll review fyrir ákveðinn kúrs
     */
    List<Review> findByLangtNumer(String langtNumer);
    /*
        Bætir við ummælum um kúrs
     */
    Review save (Review review);
}
