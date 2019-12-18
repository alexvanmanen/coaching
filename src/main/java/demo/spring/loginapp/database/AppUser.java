package demo.spring.loginapp.database;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Transactional
public class AppUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "roles")
    private String roles;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public AppUser() {}

    public AppUser(
        String username,
        String firstName,
        String lastName,
        String password,
        String roles) {

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = true;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String[] getRoles() {
        return roles.split(",");
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
