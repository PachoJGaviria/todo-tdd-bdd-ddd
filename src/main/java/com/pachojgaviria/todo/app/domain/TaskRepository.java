package com.pachojgaviria.todo.app.domain;

import com.pachojgaviria.todo.app.domain.valueobject.TaskId;

public interface TaskRepository {
  void save(Task task);

  boolean exists(TaskId taskId);
}
