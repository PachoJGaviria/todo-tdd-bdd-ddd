package com.pachojgaviria.todo.app.domain.exception;

import com.pachojgaviria.todo.app.domain.valueobject.TaskId;

public class TaskAlreadyExists extends RuntimeException {
  public TaskAlreadyExists(TaskId taskId) {
    super("The task with id " + taskId + " already exists.");
  }
}
