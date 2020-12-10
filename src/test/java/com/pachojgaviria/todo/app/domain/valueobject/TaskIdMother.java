package com.pachojgaviria.todo.app.domain.valueobject;

import java.util.UUID;

// pattern Mother
public class TaskIdMother {
  public static TaskId random() {
    // Tell don`t ask
    return new TaskId(UUID.randomUUID().toString());
  }
}
