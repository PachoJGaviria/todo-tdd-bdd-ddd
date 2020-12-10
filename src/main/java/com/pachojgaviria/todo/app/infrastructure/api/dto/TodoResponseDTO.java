package com.pachojgaviria.todo.app.infrastructure.api.dto;

public class TodoResponseDTO {

  private String internalMessage;

  public TodoResponseDTO(String internalMessage) {
    this.internalMessage = internalMessage;
  }

  public String getInternalMessage() {
    return internalMessage;
  }
}
