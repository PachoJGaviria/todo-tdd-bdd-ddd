package com.pachojgaviria.todo.app.application;

import com.pachojgaviria.todo.app.domain.Task;
import com.pachojgaviria.todo.app.domain.TaskRepository;
import com.pachojgaviria.todo.app.domain.exception.TaskAlreadyExists;
import com.pachojgaviria.todo.app.domain.valueobject.TaskId;
import com.pachojgaviria.todo.app.domain.valueobject.TaskName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CreateTask {

  private final TaskRepository taskRepository;

  @Autowired
  public CreateTask(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Transactional
  public Task createTask(TaskId taskId, TaskName taskName) {
    if (taskRepository.exists(taskId)) {
      throw new TaskAlreadyExists(taskId);
    }
    var task = Task.create(taskId, taskName);
    taskRepository.save(task);
    return task;
  }
}
