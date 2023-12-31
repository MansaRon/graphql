package co.za.graphql.project.graphql.controller;

import co.za.graphql.project.graphql.business.mutation.TaskMutationService;
import co.za.graphql.project.graphql.business.query.TaskQueryService;
import co.za.graphql.project.graphql.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class TaskController {

    @Autowired
    private final TaskQueryService taskQuery;
    private final TaskMutationService taskMutationService;

    @QueryMapping
    @Secured("ROLE_USER")
    public List<Task> getAllTasks() {
        return taskQuery.getAllTasks();
    }

    @QueryMapping
    @Secured("ROLE_USER")
    public List<Task> getTasksByStatus(@Argument boolean completed) {
        return taskQuery.getAllTasksByStatus(completed);
    }

    @MutationMapping
    @Secured("ROLE_USER")
    public Task createTask(@Argument String title, @Argument String description, @Argument boolean completed) {
        return taskMutationService.createTask(title, description, completed);
    }

    @MutationMapping
    @Secured("ROLE_USER")
    public Task updateTask(@Argument long id, @Argument String title, @Argument String description, @Argument boolean completed) throws Exception {
        return taskMutationService.updateTask(id, title, description, completed);
    }

    @MutationMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public boolean deleteTask(@Argument long id) {
        return taskMutationService.deleteTask(id);
    }

    @MutationMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public boolean markTaskAsCompleted(@Argument long id) {
        return taskMutationService.markTaskAsCompleted(id);
    }
}
