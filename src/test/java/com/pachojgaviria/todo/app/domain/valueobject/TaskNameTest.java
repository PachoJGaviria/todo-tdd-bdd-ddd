package com.pachojgaviria.todo.app.domain.valueobject;

import static org.junit.jupiter.api.Assertions.*;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class TaskNameTest {
  
  @Test
  public void shouldFailWhenNameIsNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var name = (String) null;
      //when
      new TaskName(name);
    });
  }

  @Test
  public void shouldFailWhenNameIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var name = "";
      //when
      new TaskName(name);
    });
  }

  @Test
  public void shouldFailWhenNameIsBlank() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var name = "  ";
      //when
      new TaskName(name);
    });
  }

  @Test
  public void shouldFailWhenNameIsTooLong() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var faker = new Faker();
      var longText = new StringBuilder();
      for (int i = 0; i < 31; i++) {
        longText.append("?");
      }
      var name = faker.bothify(longText.toString());
      //when
      new TaskName(name);
    });
  }

  @Test
  public void shouldFailWhenNameIsNotAlphanumeric() {
    assertThrows(IllegalArgumentException.class, () -> {
      //given
      var name = (String) null;
      //when
      new TaskName(name);
    });
  }

  @Test
  public void shouldCreateTaskName() {
    //given
    var faker = new Faker();
    var name = faker.funnyName().name();
    //when
    var taskName = new TaskName(name);
    //then
    assertEquals(name, taskName.getValue());
  }
}
