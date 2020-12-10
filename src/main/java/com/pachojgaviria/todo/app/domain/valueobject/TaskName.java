package com.pachojgaviria.todo.app.domain.valueobject;

import java.util.Objects;

public class TaskName {
  private static final int TASK_NAME_LONG = 30;

  private static final String ALPHANUMERIC_REGEX = "^[a-zA-Z0-9 .-]+$";

  private final String name;

  public TaskName(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("The task name is required.");
    }
    if (name.length() > TASK_NAME_LONG) {
      throw new IllegalArgumentException("The task name is too long.");
    }
    if (!name.matches(ALPHANUMERIC_REGEX)) {
      throw new IllegalArgumentException("The task name is not safe.");
    }
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskName taskName = (TaskName) o;
    return Objects.equals(name, taskName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "TaskName{name='" + name + "'}";
  }

  public String getValue() {
    return name;
  }
}
