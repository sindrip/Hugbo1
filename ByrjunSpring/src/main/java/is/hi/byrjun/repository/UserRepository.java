package is.hi.byrjun.repository;

import is.hi.byrjun.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 */

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Nær í öll User
     * @return listi af User
     */
    List<User> findAll();

    /**
     * Bætir við User
     * @param User
     */
    User save (User user);

    /**
     * Sækir User eftir email
     * @param email
     */
    User findByEmail(String email);
}