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

import java.util.Optional;

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
    void updateTask() throws Exception {
        Task task = new Task();
        task.setId(1);
        task.setTitle("Springboot Framework");
        task.setDescription("A framework using for quick development");
        task.setCompleted(false);

        Task updateTask = new Task(2, ".NET", "A terrible framework", false);
        Mockito.when(taskRepository.findById(task.getId())).thenReturn(Optional.of(updateTask));

        Task updatedTask = taskMutationService.updateTask(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted());

        Mockito.verify(taskRepository).save(updatedTask);

        assertEquals(task.getTitle(), updatedTask.getTitle());
        assertEquals(task.getDescription(), updatedTask.getDescription());
        assertEquals(task.isCompleted(), updatedTask.isCompleted());
    }

    @Test
    void deleteTask() {
    }

    @Test
    void markTaskAsCompleted() {
    }
}