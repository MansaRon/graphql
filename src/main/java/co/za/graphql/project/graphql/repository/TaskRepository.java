package co.za.graphql.project.graphql.repository;

import co.za.graphql.project.graphql.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
