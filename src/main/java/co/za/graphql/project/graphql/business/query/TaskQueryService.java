package co.za.graphql.project.graphql.business.query;

import co.za.graphql.project.graphql.model.Task;

import java.util.List;

public interface TaskQueryService {

    List<Task> getAllTasks();

    List<Task> getAllTasksByStatus(boolean completed);

}
