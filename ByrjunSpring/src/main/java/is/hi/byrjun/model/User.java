package is.hi.byrjun.model;


import javax.persistence.*;
import java.util.Date;
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * User klasinn inniheldur id, nafn notenda, dagsetningu sem aðgangurinn var búinn til og fjöldi umsagna
 */

@Entity
@Table(name="Review")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nafn;
    private Date createdOn;
    @ColumnDefault("'0'")
    @Column(name = "nrOfReviews")
    private int nrOfReviews;

    public String getNafn() {
        return nafn;
    }

    public void setNafn(String nafn) {
        this.nafn = nafn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
