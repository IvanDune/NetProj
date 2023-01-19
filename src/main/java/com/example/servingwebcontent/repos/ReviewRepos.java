package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Game;
import com.example.servingwebcontent.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepos extends JpaRepository<Review, Long> {
    Iterable<Review> findByAuthor(String author);
}
