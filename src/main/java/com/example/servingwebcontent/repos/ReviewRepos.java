package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.dto.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepos extends JpaRepository<Review, Long> {
    Iterable<Review> findByAuthor(String author);
    Iterable<Review> findByMaster(String master);
}
