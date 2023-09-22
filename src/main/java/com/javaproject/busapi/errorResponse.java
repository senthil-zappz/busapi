package com.javaproject.busapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class errorResponse {
      private String message;
      private LocalDateTime timestamp;
}
