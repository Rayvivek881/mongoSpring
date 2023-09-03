package com.example.mongomemories.documents;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {
  private String message;
  private boolean success;
  private Object data;
}
