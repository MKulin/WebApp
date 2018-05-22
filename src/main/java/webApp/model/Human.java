package webApp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "human")
public class Human {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    @NotNull
    @Size(min = 3, max = 20, message = "Username must be at least 3 characters length")
    private String username;

    @Column(name = "firstName")
    @NotNull
    @Size(min = 3, max = 20, message = "First name must be at least 3 characters length")
    private String firstName;

    @Column(name = "lastName")
    @NotNull
    @Size(min = 3, max = 20, message = "Last name must be at least 3 characters length")
    private String lastName;

    @Column(name = "email")
    @NotNull
    @Email(message = "E-mail field has to be in an e-mail format.")
    private String email;

    @Column(name = "password")
    @NotNull
    @Size(min = 5, max = 20, message = "Too short password")
    private String password;

    public Human(){

    }

    public Human(String username){
        this.username = username;
    }

    public Human(long id, String username){
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
