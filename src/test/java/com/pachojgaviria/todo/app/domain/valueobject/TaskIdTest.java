package com.pachojgaviria.todo.app.domain.valueobject;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TaskIdTest {

  @Test
  public void shouldFailWhenIdIsNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var id = (String) null;
      //when
      new TaskId(id);
    });
  }

  @Test
  public void shouldFailWhenIdIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var id = "";
      //when
      new TaskId(id);
    });
  }

  @Test
  public void shouldFailWhenIdIsBlank() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var id = "  ";
      //when
      new TaskId(id);
    });
  }

  @Test
  public void shouldFailWhenIdIsNotUuid() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var faker = new Faker();
      var id = faker.rickAndMorty().character();
      //when
      new TaskId(id);
    });
  }

  @Test
  public void shouldCreateTaskId() {
    //given
    var id = UUID.randomUUID().toString();
    //when
    var taskId = new TaskId(id);
    //then
    assertNotNull(taskId);
    assertEquals(id, taskId.getId());
  }
}
