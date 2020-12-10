package com.pachojgaviria.todo.app.infrastructure.api.dto;

import com.github.javafaker.Faker;

import java.util.UUID;

public class CreateTaskDTOMother {

  public static CreateTaskDTO random() {
    var faker = new Faker();
    var uuid = UUID.randomUUID().toString();
    return new CreateTaskDTO(uuid, faker.funnyName().name());

  }
}
