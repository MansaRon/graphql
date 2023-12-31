package co.za.graphql.project.graphql.repository;

import co.za.graphql.project.graphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByLogin(String login);
}
