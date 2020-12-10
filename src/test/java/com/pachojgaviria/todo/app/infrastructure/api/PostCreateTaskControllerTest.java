package com.pachojgaviria.todo.app.infrastructure.api;

import com.pachojgaviria.todo.app.application.CreateTask;
import com.pachojgaviria.todo.app.domain.valueobject.TaskId;
import com.pachojgaviria.todo.app.domain.valueobject.TaskName;
import com.pachojgaviria.todo.app.infrastructure.api.dto.CreateTaskDTOMother;
import com.pachojgaviria.todo.app.infrastructure.api.dto.TodoResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.then;
import static org.mockito.MockitoAnnotations.openMocks;

public class PostCreateTaskControllerTest {

  @Mock
  private CreateTask createTask;

  @Captor
  private ArgumentCaptor<TaskId> taskIdCaptor;

  @Captor
  private ArgumentCaptor<TaskName> taskNameCaptor;

  private PostCreateTaskController postCreateTaskController;

  @BeforeEach
  public void setup() {
    openMocks(this);
    postCreateTaskController = new PostCreateTaskController(createTask);
  }


  @Test
  public void shouldCreateTask() {
    // given
    var createTaskDTO = CreateTaskDTOMother.random();

    // when
    ResponseEntity<TodoResponseDTO> response = postCreateTaskController.post(createTaskDTO);

    // then
    then(createTask).should().createTask(taskIdCaptor.capture(), taskNameCaptor.capture());
    assertEquals(createTaskDTO.getId(), taskIdCaptor.getValue().getId());
    assertEquals(createTaskDTO.getName(), taskNameCaptor.getValue().getValue());

    // validate response
    assertNotNull(response);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals("TODO_CREATED", response.getBody().getInternalMessage());
  }


}