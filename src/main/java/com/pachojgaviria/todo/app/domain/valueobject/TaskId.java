package com.pachojgaviria.todo.app.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class TaskId {

  private final String id;

  public TaskId(String id) {
    if (id == null || id.isBlank()) {
      throw new IllegalArgumentException("The task id is required.");
    }
    this.id = UUID.fromString(id).toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskId taskId = (TaskId) o;
    return Objects.equals(id, taskId.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "TaskId{id='" + id + "'}";
  }

  public String getId() {
    return id;
  }
}
