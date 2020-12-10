package com.pachojgaviria.todo.app.infrastructure.api.dto;

import javax.validation.constraints.NotEmpty;

public class CreateTaskDTO {

  @NotEmpty(message = "TASK_ID_REQUIRED")
  private String id;

  @NotEmpty(message = "TASK_NAME_REQUIRED")
  private String name;

  public CreateTaskDTO(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
