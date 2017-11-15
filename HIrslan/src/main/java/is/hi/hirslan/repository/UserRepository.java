package is.hi.hirslan.repository;

import is.hi.hirslan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date Október 2017
 * @description Repository fyrir allan notendur. Sér um að sækja notendaupplýsingar úr gagnagrunni
 * */

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @description Sækir upplýsingar um notanda úr gagnagrunni
     * @param notendanafn þess notandi sem verið er að sækja upplýsingar um
     **/
    User findByUsername(String username);

    /**
     * @description Sækir alla notendur úr gagnagrunni
     * @param Nothing
     **/
    List<User> findAll();
}