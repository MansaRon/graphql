package co.za.graphql.project.graphql.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;
}
