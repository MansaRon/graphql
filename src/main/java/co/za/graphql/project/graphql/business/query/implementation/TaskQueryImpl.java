package co.za.graphql.project.graphql.business.query.implementation;

import co.za.graphql.project.graphql.business.query.TaskQueryService;
import co.za.graphql.project.graphql.model.Task;
import co.za.graphql.project.graphql.repository.TaskRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class TaskQueryImpl implements GraphQLQueryResolver, TaskQueryService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllTasksByStatus(boolean completed) {
        List<Task> tasks = taskRepository.findAll();

        if (completed) {
            return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
        }
        else {
            return tasks.stream().filter(task -> !task.isCompleted()).collect(Collectors.toList());
        }
    }

}
