package com.crio.video_rental_basic.controller;

import com.crio.video_rental_basic.entity.Video;
import com.crio.video_rental_basic.service.VideoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {

  private final VideoService videoService;

  @GetMapping
  public List<Video> getAllVideos() {
    return videoService.getAllVideos();
  }

  @PostMapping
  public Video create(@RequestBody Video video) {
    return videoService.createVideo(video);
  }

  @PutMapping("/{id}")
  public Video update(@PathVariable Long id, @RequestBody Video video) {
    return videoService.updateVideo(id, video);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    videoService.deleteVideo(id);
  }
}
