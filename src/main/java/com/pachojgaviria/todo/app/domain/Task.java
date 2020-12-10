package com.pachojgaviria.todo.app.domain;

import com.pachojgaviria.todo.app.domain.valueobject.TaskId;
import com.pachojgaviria.todo.app.domain.valueobject.TaskName;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Task {

  private final TaskId taskId;

  private final TaskName taskName;

  private final Date createdAt;

  private boolean done;

  public Task(TaskId taskId, TaskName taskName) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.createdAt = Date.from(Instant.now());
    this.done = false;
  }

  public static Task create(TaskId taskId, TaskName taskName) {
    return new Task(taskId, taskName);
  }

  public TaskId getId() {
    return taskId;
  }

  public TaskName getName() {
    return taskName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(taskId, task.taskId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId);
  }

  public boolean isDone() {
    return done;
  }

  public Date getCreationDate() {
    return createdAt;
  }
}
