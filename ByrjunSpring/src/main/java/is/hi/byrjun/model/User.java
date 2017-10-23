package is.hi.byrjun.model;


import javax.persistence.*;
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * User klasinn inniheldur id, nafn notenda, dagsetningu sem aðgangurinn var búinn til og fjöldi umsagna
 */

@Entity
@Table (name = "User")
public class User {

    @Id
    private String email;
    private String password;
    @ColumnDefault("'0'")
    @Column(name = "nrOfReviews")
    private int nrOfReviews;

    public String getEmail() {
        return email;
    }

    public void setnafn(String nafn) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNrOfReviews() {
        return nrOfReviews;
    }

    public void setNrOfReviews(int nrOfReviews) {
        this.nrOfReviews = nrOfReviews;
    }

}
