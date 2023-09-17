package co.za.graphql.project.graphql.business.mutation;

import co.za.graphql.project.graphql.model.Task;

public interface TaskMutationService {

    Task createTask(String title, String description, boolean completed);

    Task updateTask(long id, String title, String description, boolean completed) throws Exception;

    boolean deleteTask(long id);

    boolean markTaskAsCompleted(long id);
}
