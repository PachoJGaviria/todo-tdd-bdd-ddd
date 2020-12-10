package com.pachojgaviria.todo.app.infrastructure.api;

import com.pachojgaviria.todo.app.application.CreateTask;
import com.pachojgaviria.todo.app.domain.valueobject.TaskId;
import com.pachojgaviria.todo.app.domain.valueobject.TaskName;
import com.pachojgaviria.todo.app.infrastructure.api.dto.CreateTaskDTO;
import com.pachojgaviria.todo.app.infrastructure.api.dto.TodoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class PostCreateTaskController {

  private final CreateTask createTask;

  @Autowired
  public PostCreateTaskController(CreateTask createTask) {
    this.createTask = createTask;
  }

  @PostMapping(value = "/todo", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TodoResponseDTO> post(@Valid @NotNull CreateTaskDTO createTaskDTO) {
    var taskId = new TaskId(createTaskDTO.getId());
    var taskName = new TaskName(createTaskDTO.getName());

    createTask.createTask(taskId, taskName);

    var result = new TodoResponseDTO("TODO_CREATED");
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(result);
  }
}
