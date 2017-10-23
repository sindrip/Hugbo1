package is.hi.byrjun.services;

import is.hi.byrjun.model.User;

import java.util.List;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Þjónusta sem talar við Course Repository
 */

public interface UserService {

    /**
     * Skilar öllum Courses í courseRep
     *
     * @return listi af Users
     */
    public List<User> allUser();

    /**
     * Skilar einum user úr userRep eftir email
     *
     * @return single User
     */
    public User singleUser(String email);

    /**
     * Skilar einum user úr userRep eftir email
     *
     * @return single User
     */
    public User save(User user);


}