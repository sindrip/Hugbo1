package is.hi.hirslan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date October 2017
 * @Description Módel klassi sem heldur utan um upplýsingar fyrir notendur
 *
 *
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @Pattern(regexp="[a-z0-9._%+-]+@hi.is$")
    private String username;
    //Notendanafn. Verður að vera á sniðinu sem hí biður um og vera með hi.is
    private String password;
    //Lykilorð.

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}