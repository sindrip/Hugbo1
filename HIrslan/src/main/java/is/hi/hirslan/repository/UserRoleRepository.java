package is.hi.hirslan.repository;

import is.hi.hirslan.model.User;
import is.hi.hirslan.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
    * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
    * @author Ketill Guðmundsson:email keg13@hi.is,
    * @author Björn Guðmundsson:email bjg49@hi.is
    * @date Október 2017
    * @description Repository fyrir user roles.
 */

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
    /*
        * @description Fall sem skilar hlutverki hjá notanda
        * @param Notandi af taginu user.
     */
    List<UserRole> findByUser (User user);
}
