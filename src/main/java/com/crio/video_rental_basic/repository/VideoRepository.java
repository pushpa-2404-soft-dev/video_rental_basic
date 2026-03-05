package com.crio.video_rental_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rentvideo.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}