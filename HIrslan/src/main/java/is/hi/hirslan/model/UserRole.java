package is.hi.hirslan.model;

import javax.persistence.*;

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date October 2017
 */

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Auto incremented primary key fyrir hlutverk notenda.
    @ManyToOne
    @JoinColumn(name="users", referencedColumnName="username")
    private User user;
    //Vísar í user og þá hefur samsvarandi user viðkomandi hlutverk
    private String role;
    //Segir til um hlutverk notandans, til dæmis admin eða venjulegur user

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
