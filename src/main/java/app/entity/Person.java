package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends EntityBase {

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
