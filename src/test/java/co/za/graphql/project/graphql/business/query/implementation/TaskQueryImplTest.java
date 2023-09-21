package co.za.graphql.project.graphql.business.query.implementation;

import co.za.graphql.project.graphql.business.query.TaskQueryService;
import co.za.graphql.project.graphql.model.Task;
import co.za.graphql.project.graphql.repository.TaskRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TaskQueryImpl.class)
class TaskQueryImplTest {

    @MockBean
    private TaskQueryService taskQueryService;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    void getAllTasks() {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Testing", "Unit testing in Springboot", true),
                new Task(2L, "Testing", "Unit testing in .NET", false),
                new Task(3L, "Testing", "Unit testing in Django", false)
        );

        Mockito.when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskQueryService.getAllTasks();

        Assert.assertEquals(3, result.size());
    }

    @Test
    void getAllTasksByStatus() {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Testing", "Unit testing in Springboot", true),
                new Task(2L, "Testing", "Unit testing in .NET", false),
                new Task(3L, "Testing", "Unit testing in Django", false)
        );

        Mockito.when(taskRepository.findAll().stream().filter(Task::isCompleted).collect(Collectors.toList())).thenReturn(tasks);

        List<Task> result = taskQueryService.getAllTasksByStatus(true);

        for (Task task : result) {
            assertTrue(task.isCompleted());
        }
    }

}