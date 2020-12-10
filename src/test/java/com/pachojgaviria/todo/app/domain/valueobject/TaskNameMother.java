package com.pachojgaviria.todo.app.domain.valueobject;

import com.github.javafaker.Faker;

public class TaskNameMother {

  public static TaskName random() {
    var faker = new Faker();
    return new TaskName(faker.funnyName().name());
  }
}
