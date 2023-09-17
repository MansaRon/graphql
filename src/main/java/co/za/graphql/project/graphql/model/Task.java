package co.za.graphql.project.graphql.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "completed")
    private boolean completed;
}
