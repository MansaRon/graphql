package co.za.graphql.project.graphql.business.mutation.implementation;

import co.za.graphql.project.graphql.business.mutation.TaskMutationService;
import co.za.graphql.project.graphql.model.Task;
import co.za.graphql.project.graphql.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TaskMutationImpl.class)
class TaskMutationImplTest {

    @MockBean
    private TaskMutationService taskMutationService;

    @MockBean
    private TaskRepository taskRepository;

    @Captor
    private ArgumentCaptor<Task> taskCaptor;

    @Test
    void createTask() {
        Task task = new Task();
        task.setId(1);
        task.setTitle("Springboot Framework");
        task.setDescription("A framework using for quick development");
        task.setCompleted(false);

        Mockito.when(taskRepository.save(task)).thenReturn(new Task());

        taskMutationService.createTask(task.getTitle(), task.getDescription(), task.isCompleted());

        Mockito.verify(taskRepository).save(taskCaptor.capture());

        Task savedTask = taskCaptor.getValue();
        assertEquals(task.getTitle(), savedTask.getTitle());
        assertEquals(task.getDescription(), savedTask.getDescription());
        assertEquals(task.isCompleted(), savedTask.isCompleted());
    }

    @Test
    void updateTask() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void markTaskAsCompleted() {
    }
}