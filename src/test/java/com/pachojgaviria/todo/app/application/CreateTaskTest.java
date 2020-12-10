package com.pachojgaviria.todo.app.application;

import com.pachojgaviria.todo.app.domain.Task;
import com.pachojgaviria.todo.app.domain.TaskRepository;
import com.pachojgaviria.todo.app.domain.exception.TaskAlreadyExists;
import com.pachojgaviria.todo.app.domain.valueobject.TaskIdMother;
import com.pachojgaviria.todo.app.domain.valueobject.TaskNameMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.MockitoAnnotations.openMocks;

public class CreateTaskTest {

  private CreateTask createTask;

  @Mock
  private TaskRepository taskRepository;

  @Captor
  private ArgumentCaptor<Task> taskCaptor;

  @BeforeEach
  public void setup() {
    openMocks(this);
    createTask = new CreateTask(taskRepository);
  }

  @Test
  public void shouldCreatedTask() {
    // Pattern AAA / Given-When-Then
    // Given
    var taskId = TaskIdMother.random();
    var taskName = TaskNameMother.random();

    // When
    var task = createTask.createTask(taskId, taskName);

    // Then
    then(taskRepository).should().save(taskCaptor.capture());
    var taskExpected = taskCaptor.getValue();

    assertNotNull(task);
    assertNotNull(task.getId());
    assertEquals(task.getId(), taskId);
    assertEquals(task.getId(), taskExpected.getId());
    assertNotNull(task.getName());
    assertEquals(task.getName(), taskName);
    assertEquals(task.getName(), taskExpected.getName());
    assertFalse(task.isDone());
    assertNotNull(task.getCreationDate());
    assertEquals(task, taskExpected);
  }


  @Test
  public void shouldThrowTaskAlreadyExists() {
    assertThrows(TaskAlreadyExists.class, () -> {
      // Given
      var taskId = TaskIdMother.random();
      var taskName = TaskNameMother.random();
      given(taskRepository.exists(eq(taskId))).willReturn(true);

      // When
      createTask.createTask(taskId, taskName);
    });
  }

}
