package com.crio.video_rental_basic.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class VideoDTO {

  @NotBlank(message = "Title is required")
  private String title;

  @NotBlank(message = "Director is required")
  private String director;

  @NotBlank(message = "Genre is required")
  private String genre;
}
