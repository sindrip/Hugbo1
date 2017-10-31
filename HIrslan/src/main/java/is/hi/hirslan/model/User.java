package is.hi.hirslan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Pattern(regexp="[a-z0-9._%+-]+@hi.is$")
    private String username;
    @Size(min=6, max=30)
    private String password;

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