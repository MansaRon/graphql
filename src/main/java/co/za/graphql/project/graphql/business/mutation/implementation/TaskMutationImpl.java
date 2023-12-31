package co.za.graphql.project.graphql.business.mutation.implementation;

import co.za.graphql.project.graphql.business.mutation.TaskMutationService;
import co.za.graphql.project.graphql.model.Task;
import co.za.graphql.project.graphql.repository.TaskRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@AllArgsConstructor
public class TaskMutationImpl implements TaskMutationService, GraphQLMutationResolver {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(String title, String description, boolean completed) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(completed);

        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(long id, String title, String description, boolean completed) throws Exception {
        Optional<Task> checkTask = taskRepository.findById(id);

        if (checkTask.isPresent()) {
            Task task = checkTask.get();
            task.setTitle(title);
            task.setDescription(description);
            task.setCompleted(completed);
            taskRepository.save(task);
            return task;
        }
        else
            throw new Exception("Task not found");
    }

    @Override
    public boolean deleteTask(long id) {
        Optional<Task> findTask = taskRepository.findById(id);
        if (findTask.isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean markTaskAsCompleted(long id) {
        Task task = taskRepository.getById(id);
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
        return task.isCompleted();
    }


}
