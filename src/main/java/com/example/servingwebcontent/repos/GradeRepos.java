package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepos extends JpaRepository<Game, Long> {

}
