package com.crio.video_rental_basic.service;

import com.crio.video_rental_basic.entity.Video;
import com.crio.video_rental_basic.repository.VideoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoService {

  private final VideoRepository videoRepository;

  public List<Video> getAllVideos() {
    return videoRepository.findAll();
  }

  public Video createVideo(Video video) {
    return videoRepository.save(video);
  }

  public Video updateVideo(Long id, Video video) {
    Video existing = videoRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("Video not found"));

    existing.setTitle(video.getTitle());
    existing.setDirector(video.getDirector());
    existing.setGenre(video.getGenre());

    return videoRepository.save(existing);
  }

  public void deleteVideo(Long id) {
    videoRepository.deleteById(id);
  }
}
